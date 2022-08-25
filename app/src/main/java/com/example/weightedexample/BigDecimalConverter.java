package com.example.weightedexample;




import androidx.room.TypeConverter;

import java.math.BigDecimal;

public class BigDecimalConverter {

        @TypeConverter
        public BigDecimal toBigDecimal(String value) {
            return value == null ? null : new BigDecimal(value);
        }

        @TypeConverter
        public String toPlainString(BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                return null;
            } else {
                return bigDecimal.toPlainString();
            }
        }

}
