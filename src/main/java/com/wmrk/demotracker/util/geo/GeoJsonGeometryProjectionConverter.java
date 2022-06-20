package com.wmrk.demotracker.util.geo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;



public class GeoJsonGeometryProjectionConverter {
    public static final int GEOCONV_STRIDE_XY = 2;

    public static List<Double> readGeometryFromText(char[] src, double factor, int stride) {
        List<Double> numbers = decodeDeltas(src, factor, stride);
        flipXY(numbers);
//            const coordinates = inflateCoordinates(
//                flatCoordinates,
//                0,
//                flatCoordinates.length,
//                stride
//        );

        return numbers;
    }

    public static void flipXY(List<Double> numbers) {
        for(int i = 0; i < numbers.size(); i+=2) {
            double val = numbers.get(i);
            numbers.set(i, numbers.get(i + 1));
            numbers.set(i + 1, val);
        }
    }

    public static List<Double> decodeDeltas(char[] src, double factor, int stride) {
        int d;
        double[] lastNumbers = new double[stride];
        
        for (d = 0; d < stride; ++d) {
            lastNumbers[d] = 0;
        }

        List<Double> numbers = decodeFloats(src, factor);

        for (int i = 0, ii = numbers.size(); i < ii; ) {
            for (d = 0; d < stride; ++d, ++i) {
                lastNumbers[d] += numbers.get(i);

                numbers.set(i, lastNumbers[d]);
            }
        }

        return numbers;
    }

    private static List<Double> decodeFloats(char[] src, double factor) {
        List<Double> num_out = new ArrayList<>();
        List<Integer> numbers = decodeSignedIntegers(src);
        for (int i = 0, ii = numbers.size(); i < ii; ++i) {
            num_out.add((double)numbers.get(i) / (double) factor);
        }
        return num_out;
    }

    private static List<Integer> decodeSignedIntegers(char[] encoded) {
        List<Integer> numbers = decodeUnsignedIntegers(encoded);

        for (int i = 0, ii = numbers.size(); i < ii; ++i) {
            int num = numbers.get(i);
            numbers.set(i, ((num & 1) != 0) ? ~(num >> 1) : num >> 1);
        }
        return numbers;
    }

    /**
     * Decode a list of unsigned integers from an encoded string
     *
     * @param {string} encoded An encoded string.
     * @return {Array<number>} A list of unsigned integers.
     */
    @NotNull
    private static List<Integer> decodeUnsignedIntegers(char[] encoded) {
        List<Integer> numbers = new ArrayList<>();
        Integer current = 0;
        Integer shift = 0;

        for (int i = 0, ii = encoded.length; i < ii; ++i) {
            char b = (char) (encoded[i] - 63);
            current |= (b & 0x1f) << shift;
            if (b < 0x20) {
                numbers.add((int)current);
                current = 0;
                shift = 0;
            } else {
                shift += 5;
            }
        }
        return numbers;
    }

    /**
     * Encode a list of n-dimensional points and return an encoded string
     *
     * Attention: This function will modify the passed array!
     *
     * @param {Array<number>} numbers A list of n-dimensional points.
     * @param {number} stride The number of dimension of the points in the list.
     * @param {number} [opt_factor] The factor by which the numbers will be
     *     multiplied. The remaining decimal places will get rounded away.
     * @return {string} The encoded string.
     * @api
     */
    @NotNull
    public static String encodeDeltas(List<Double> numbers, double factor, int stride) {
        int d;
        double[] lastNumbers = new double[stride];

        for (d = 0; d < stride; ++d) {
            lastNumbers[d] = 0;
        }

        for (int i = 0, ii = numbers.size(); i < ii; ) {
            for (d = 0; d < stride; ++d, ++i) {
                double num = numbers.get(i);
                double delta = num - lastNumbers[d];
                lastNumbers[d] = num;

                numbers.set(i, delta);
            }
        }

        return encodeFloats(numbers, factor);
    }

    private static String encodeFloats(List<Double> numbers, double factor) {
        List<Integer> newNumbers = new ArrayList<>();

        for (int i = 0, ii = numbers.size(); i < ii; ++i) {
            newNumbers.add((int)Math.round(numbers.get(i) * factor));
        }

        return encodeSignedIntegers(newNumbers);
    }

    private static String encodeSignedIntegers(List<Integer> numbers) {
        for (int i = 0, ii = numbers.size(); i < ii; ++i) {
            int num = numbers.get(i);
            numbers.set(i, num < 0 ? ~(num << 1) : num << 1);
        }
        return encodeUnsignedIntegers(numbers);
    }

    @NotNull
    private static String encodeUnsignedIntegers(List<Integer> numbers) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0, ii = numbers.size(); i < ii; ++i) {
            encoded.append(encodeUnsignedInteger(numbers.get(i)));
        }
        return encoded.toString();
    }

    private static String encodeUnsignedInteger(int num) {
        char value;
        StringBuilder encoded = new StringBuilder();

        while (num >= 0x20) {
            value = (char) ((0x20 | (num & 0x1f)) + 63);
            encoded.append(value);
            num >>= 5;
        }
        value = (char) (num + 63);
        encoded.append(value);
        return encoded.toString();
    }
}
