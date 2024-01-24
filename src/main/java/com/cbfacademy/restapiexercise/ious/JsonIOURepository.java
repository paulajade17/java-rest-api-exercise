package com.cbfacademy.restapiexercise.ious;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class JsonIOURepository implements IOURepository {
    private final String filePath;
    private final Gson gson;
    private final Map<UUID, IOU> database;

    public JsonIOURepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        gson = new GsonBuilder()
                .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
                .create();
        database = loadDataFromJson();
    }

    class InstantTypeAdapter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {
        @Override
        public JsonElement serialize(Instant instant, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(instant.toString());
        }

        @Override
        public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            return Instant.parse(json.getAsString());
        }
    }

    private Map<UUID, IOU> loadDataFromJson() {
        try (Reader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<UUID, IOU>>() {
            }.getType();

            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private void saveDataToJson() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(database, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<IOU> findAll() {
        return database.values();
    }

    @Override
    public Optional<IOU> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public <S extends IOU> S save(S entity) {
        database.put(entity.getId(), entity);
        saveDataToJson();

        return entity;
    }

    @Override
    public void deleteById(UUID id) {
        database.remove(id);
        saveDataToJson();
    }

    @Override
    public List<IOU> searchByBorrower(String name) {
        return database.values().stream()
                .filter(iou -> iou.getBorrower().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<IOU> searchByLender(String name) {
        return database.values().stream()
                .filter(iou -> iou.getLender().equals(name))
                .collect(Collectors.toList());
    }
}