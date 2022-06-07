package com.wmrk.demotracker.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wmrk.demotracker.entity.geo.BaseGeoPoint;
import com.wmrk.demotracker.geo.GeoJsonGeometryProjectionConverter;
import com.wmrk.demotracker.geo.SphericalMercatorConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.wmrk.demotracker.geo.SphericalMercatorConverter.LAT_LON_PRECISION;

public class GeoJsonTrackSerializer extends StdSerializer<GeoJsonEntity> {

    public GeoJsonTrackSerializer() {
        this(null);
    }

    public GeoJsonTrackSerializer(Class<GeoJsonEntity> t) {
        super(t);
    }

    @Override
    public void serialize(
            GeoJsonEntity value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeFieldName("routes");
        jgen.writeStartArray();
        jgen.writeStartObject();
        jgen.writeStringField("geometry", getSerializedPointList(value.getTrack().getPoints()));
        jgen.writeEndObject();
        jgen.writeEndArray();
        jgen.writeEndObject();
    }

    /**
     * @return a serialized geometry field (for the short GeoJSON standard?)
     * from Base GeoPoint list
     */
    private static String getSerializedPointList(List<? extends BaseGeoPoint> points) {
        List<Double> numbers = new ArrayList<>();
        SphericalMercatorConverter converter = new SphericalMercatorConverter();

        points.forEach(point -> {
            numbers.add(point.getLat());
            numbers.add(point.getLon());
        });

        return GeoJsonGeometryProjectionConverter.encodeDeltas(numbers, LAT_LON_PRECISION, GeoJsonGeometryProjectionConverter.GEOCONV_STRIDE_XY);
    }
}