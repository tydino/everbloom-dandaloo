package com.tydino.everbloomdandaloo.Utilities;

public class MathUtility {
    public static float wrapDegrees(float value) { value = value % 360.0F; if (value >= 180.0F) value -= 360.0F; if (value < -180.0F) value += 360.0F; return value; }
    public static float lerp(float delta, float start, float end) {return start + (end - start) * delta;}
}
