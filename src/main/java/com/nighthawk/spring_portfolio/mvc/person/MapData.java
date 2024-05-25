package com.nighthawk.spring_portfolio.mvc.person;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MapData {
    private boolean nonNull;
    private int compressionlevel;
    private int height;
    private boolean infinite;
    private List<Layer> layers;
    private int nextlayerid;
    private int nextobjectid;
    private String orientation;
    private String renderorder;
    private String tiledversion;
    private int tileheight;
    private List<Tileset> tilesets;
    private int tilewidth;
    private String type;
    private String version;
    private int width;

    public MapData(int compressionlevel, int height, boolean infinite, List<Layer> layers, int nextlayerid,
            int nextobjectid, String orientation, String renderorder, String tiledversion, int tileheight,
            List<Tileset> tilesets, int tilewidth, String type, String version, int width) {
        this.nonNull = true;
        this.compressionlevel = compressionlevel;
        this.height = height;
        this.infinite = infinite;
        this.layers = layers;
        this.nextlayerid = nextlayerid;
        this.nextobjectid = nextobjectid;
        this.orientation = orientation;
        this.renderorder = renderorder;
        this.tiledversion = tiledversion;
        this.tileheight = tileheight;
        this.tilesets = tilesets;
        this.tilewidth = tilewidth;
        this.type = type;
        this.version = version;
        this.width = width;
    }

    // Getters and setters for all fields
    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("compressionlevel", compressionlevel);
        json.addProperty("height", height);
        json.addProperty("infinite", infinite);

        JsonArray layerArray = new JsonArray();
        for (Layer layer : layers) {
            layerArray.add(layer.toJson());
        }
        json.add("layers", layerArray);
        json.addProperty("nextlayerid", nextlayerid);
        json.addProperty("nextobjectid", nextobjectid);
        json.addProperty("orientation", orientation);
        json.addProperty("renderorder", renderorder);
        json.addProperty("tiledversion", tiledversion);
        json.addProperty("tileheight", tileheight);
        JsonArray tilesetArray = new JsonArray();
        for (Tileset tileset : tilesets) {
            tilesetArray.add(tileset.toJson());
        }
        json.add("tilesets", tilesetArray);
        json.addProperty("tilewidth", tilewidth);
        json.addProperty("type", type);
        json.addProperty("version", version);
        json.addProperty("width", width);
        return json;
    }

    public int getCompressionlevel() {
        return compressionlevel;
    }

    public void setCompressionlevel(int compressionlevel) {
        this.compressionlevel = compressionlevel;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isInfinite() {
        return infinite;
    }

    public void setInfinite(boolean infinite) {
        this.infinite = infinite;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public int getNextlayerid() {
        return nextlayerid;
    }

    public void setNextlayerid(int nextlayerid) {
        this.nextlayerid = nextlayerid;
    }

    public int getNextobjectid() {
        return nextobjectid;
    }

    public void setNextobjectid(int nextobjectid) {
        this.nextobjectid = nextobjectid;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getRenderorder() {
        return renderorder;
    }

    public void setRenderorder(String renderorder) {
        this.renderorder = renderorder;
    }

    public String getTiledversion() {
        return tiledversion;
    }

    public void setTiledversion(String tiledversion) {
        this.tiledversion = tiledversion;
    }

    public int getTileheight() {
        return tileheight;
    }

    public void setTileheight(int tileheight) {
        this.tileheight = tileheight;
    }

    public List<Tileset> getTilesets() {
        return tilesets;
    }

    public void setTilesets(List<Tileset> tilesets) {
        this.tilesets = tilesets;
    }

    public int getTilewidth() {
        return tilewidth;
    }

    public void setTilewidth(int tilewidth) {
        this.tilewidth = tilewidth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isNonNull() {
        return nonNull;
    }

    @NoArgsConstructor
    public static class Layer {
        private List<Integer> data;
        private int height;
        private int id;
        private String name;
        private double opacity;
        private String type;
        private boolean visible;
        private int width;
        private int x;
        private int y;

        public Layer(List<Integer> data, int height, int id, String name, double opacity, String type, boolean visible,
                int width, int x, int y) {
            this.data = data;
            this.height = height;
            this.id = id;
            this.name = name;
            this.opacity = opacity;
            this.type = type;
            this.visible = visible;
            this.width = width;
            this.x = x;
            this.y = y;
        }

        public JsonObject toJson() {
            JsonObject json = new JsonObject();
            json.addProperty("data", data.toString());
            json.addProperty("height", height);
            json.addProperty("id", id);
            json.addProperty("name", name);
            json.addProperty("opacity", opacity);
            json.addProperty("type", type);
            json.addProperty("visible", visible);
            json.addProperty("width", width);
            json.addProperty("x", x);
            json.addProperty("y", y);
            return json;
        }

        // Getters and setters for all fields

        public List<Integer> getData() {
            return data;
        }

        public void setData(List<Integer> data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getOpacity() {
            return opacity;
        }

        public void setOpacity(double opacity) {
            this.opacity = opacity;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    @NoArgsConstructor
    public static class Tileset {
        private int columns;
        private int firstgid;
        private String image;
        private int imageheight;
        private int imagewidth;
        private int margin;
        private String name;
        private int spacing;
        private int tilecount;
        private int tileheight;
        private int tilewidth;

        public Tileset(int columns, int firstgid, String image, int imageheight, int imagewidth, int margin,
                String name,
                int spacing, int tilecount, int tileheight, int tilewidth) {
            this.columns = columns;
            this.firstgid = firstgid;
            this.image = image;
            this.imageheight = imageheight;
            this.imagewidth = imagewidth;
            this.margin = margin;
            this.name = name;
            this.spacing = spacing;
            this.tilecount = tilecount;
            this.tileheight = tileheight;
            this.tilewidth = tilewidth;
        }

        public JsonObject toJson() {
            JsonObject json = new JsonObject();
            json.addProperty("columns", columns);
            json.addProperty("firstgid", firstgid);
            json.addProperty("image", image);
            json.addProperty("imageheight", imageheight);
            json.addProperty("imagewidth", imagewidth);
            json.addProperty("margin", margin);
            json.addProperty("name", name);
            json.addProperty("spacing", spacing);
            json.addProperty("tilecount", tilecount);
            json.addProperty("tileheight", tileheight);
            json.addProperty("tilewidth", tilewidth);
            return json;
        }

        // Getters and setters for all fields

        public int getColumns() {
            return columns;
        }

        public int getFirstgid() {
            return firstgid;
        }

        public void setFirstgid(int firstgid) {
            this.firstgid = firstgid;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getImageheight() {
            return imageheight;
        }

        public void setImageheight(int imageheight) {
            this.imageheight = imageheight;
        }

        public int getImagewidth() {
            return imagewidth;
        }

        public void setImagewidth(int imagewidth) {
            this.imagewidth = imagewidth;
        }

        public int getMargin() {
            return margin;
        }

        public void setMargin(int margin) {
            this.margin = margin;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSpacing() {
            return spacing;
        }

        public void setSpacing(int spacing) {
            this.spacing = spacing;
        }

        public int getTilecount() {
            return tilecount;
        }

        public void setTilecount(int tilecount) {
            this.tilecount = tilecount;
        }

        public int getTileheight() {
            return tileheight;
        }

        public void setTileheight(int tileheight) {
            this.tileheight = tileheight;
        }

        public int getTilewidth() {
            return tilewidth;
        }

        public void setTilewidth(int tilewidth) {
            this.tilewidth = tilewidth;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }

    }

    public static void main(String[] args) {
        // Create the tileset
        Tileset tileset = new Tileset(16, 1, "tilesets.png", 256, 256, 0, "tilesets", 0, 256, 16, 16);
        List<Tileset> tilesets = new ArrayList<>();
        tilesets.add(tileset);

        // Create the layer
        List<Integer> layerData = new ArrayList<>();
        // Add the data from the JSON array
        int[] dataArray = {
                17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 37, 40, 40, 40, 40, 40, 40, 37, 34, 18, 18, 18, 18, 18, 18, 18,
                18, 18, 18, 19, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34,
                34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37,
                34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 20, 21, 22, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40,
                40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 36, 37, 38, 34, 34, 34, 34, 34, 34,
                37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 52, 53, 54, 34, 34,
                34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 34,
                34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34,
                34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34,
                34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34,
                34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40,
                40, 37, 34, 34, 34, 34, 34, 34, 26, 27, 28, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40,
                40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 42, 40, 44, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34,
                34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 42, 40, 44, 34, 34, 35, 33, 34, 34, 34,
                34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 58, 56, 60, 34, 34, 35,
                33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34,
                34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34,
                34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37,
                34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 37, 40, 40, 40,
                40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34,
                37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 33, 34, 34, 34, 34, 34,
                34, 34, 34, 34, 37, 40, 40, 40, 40, 40, 40, 37, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 49, 50,
                50, 50, 50, 50, 50, 50, 50, 50, 37, 40, 40, 40, 40, 40, 40, 37, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50,
                50, 51
        };
        for (int data : dataArray) {
            layerData.add(data);
        }
        Layer layer = new Layer(layerData, 20, 1, "Tile Layer 1", 1, "tilelayer", true, 30, 0, 0);
        List<Layer> layers = new ArrayList<>();
        layers.add(layer);

        // Create the map data
        MapData map = new MapData(-1, 20, false, layers, 2, 1, "orthogonal", "right-down", "1.10.2", 16, tilesets, 16,
                "map", "1.10", 30);

        // Print the JSON representation of the map data
        System.out.println(map.toJson().toString());
    }
}
