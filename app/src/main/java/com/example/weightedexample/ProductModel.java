package com.example.weightedexample;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;


import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;


@Entity(tableName = "products",primaryKeys = {"productId", "profileId"})
public  class ProductModel implements Parcelable {

    @ColumnInfo(name = "productId")
    private int productId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "sku")
    String sku;
    @ColumnInfo(name = "upc")
    String upc;
    @ColumnInfo(name = "uom")
    String uom;
    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "salesPrice")
    BigDecimal salesPrice;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "costPrice")
    BigDecimal costPrice;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "poPrice")
    BigDecimal poPrice;


    @ColumnInfo(name = "productCategory")
    String productCategory;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "stockQty")
    BigDecimal stockQty;

    @ColumnInfo(name = "productCategoryId")
    int productCategoryId;

    @ColumnInfo(name = "isActive")
    String isActive;


    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "openingStock")
    BigDecimal openingStock;

    @Ignore
    @ColumnInfo(name = "currentStock")
    BigDecimal currentStock;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "salesQty")
    BigDecimal salesQty;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "totalQty")
    BigDecimal totalQty;

    @Ignore
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "oldStock")
    BigDecimal oldStock;


    /** Barcode type. N = Normal, W = Weighted, P = Priced */
    @ColumnInfo(name = "upcType")
    String upcType;

    @ColumnInfo(name = "profileId")
    int profileId = 1;
    @ColumnInfo(name = "tags")
    String tagSet;

    @Ignore
    List<AttributeModel> tags;


    @ColumnInfo(name = "cwUom")
    String cwUom;


    @TypeConverters(BigDecimalConverter.class)
    @ColumnInfo(name = "cwTolerance")
    BigDecimal cwTolerance;


    @TypeConverters(BigDecimalConverter.class)
    @ColumnInfo(name = "cwUomId")
    BigDecimal cwUomId;


    @ColumnInfo(name = "group1")
    String group1;

    @TypeConverters(BigDecimalConverter.class)
    @ColumnInfo(name = "weight")
    BigDecimal weight;



    @ColumnInfo(name = "cwUnitOfMeasure")
    String cwUnitOfMeasure;

    public String getCwUnitOfMeasure() {
        return cwUnitOfMeasure;
    }

    public void setCwUnitOfMeasure(String cwUnitOfMeasure) {
        this.cwUnitOfMeasure = cwUnitOfMeasure;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @ColumnInfo(name = "unitOfMeasure")
    String unitOfMeasure;






    public int getStdPrecision() {
        return stdPrecision;
    }

    public void setStdPrecision(int stdPrecision) {
        this.stdPrecision = stdPrecision;
    }

    public int getCwStdPrecision() {
        return cwStdPrecision;
    }

    public void setCwStdPrecision(int cwStdPrecision) {
        this.cwStdPrecision = cwStdPrecision;
    }
    @TypeConverters(JConverter.class)
    @ColumnInfo(name = "cwStdPrecision")
    int cwStdPrecision;

    @TypeConverters(JConverter.class)
    @ColumnInfo(name = "stdPrecision")
    int  stdPrecision;






    public String getCwUom() {
        return cwUom;
    }

    public void setCwUom(String cwUom) {
        this.cwUom = cwUom;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCwTolerance() {
        return cwTolerance;
    }

    public void setCwTolerance(BigDecimal cwTolerance) {
        this.cwTolerance = cwTolerance;
    }

    public BigDecimal getCwUomId() {
        return cwUomId;
    }

    public void setCwUomId(BigDecimal cwUomId) {
        this.cwUomId = cwUomId;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }




//    @ColumnInfo(name = "attributeSetId")
//    int attributeSetId;


    public String getTagSet() {
        return tagSet;
    }

    public void setTagSet(String tagSet) {
        this.tagSet = tagSet;
    }

    public List<AttributeModel> getTags() {
        return tags;
    }

    public void setTags(List<AttributeModel> tags) {
        this.tags = tags;
    }
    public String getTagsJson() {
        return formatTagsJson(tags);
    }

    public void setTagsJson(String tagJson) {
        this.tags = parseTagsJson(tagJson);
    }


    @Nullable
    public static String formatTagsJson(List<AttributeModel> tags) {
        if(tags != null) {
            Type tagsTypeToken = new TypeToken<List<AttributeModel>>() {}.getType();
            return CustomGsonBuilder.getGson().toJson(tags, tagsTypeToken);
        }
        return null;
    }
    @Nullable
    public static String formatTagsString(List<AttributeModel> tags) {
        StringBuffer str = new StringBuffer();
        if(tags != null) {
            for(AttributeModel tag : tags) {
                str.append(String.format("%s : %s    ", tag.getName(), tag.getValue()));
            }
        }
        return str.toString().trim();
    }
    public static List<AttributeModel> parseTagsJson(String tagJson) {
        if(tagJson != null) {
            Type tagsTypeToken = new TypeToken<List<AttributeModel>>() {}.getType();
            try {
                return  (List<AttributeModel>) CustomGsonBuilder.getGson().fromJson(tagJson, tagsTypeToken);
            } catch (Exception ex) { // for backward compatibilty

            }
        }
        return null;
    }
    public int getProfileId() {

        return profileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getPoPrice() {
        return poPrice;
    }

    public void setPoPrice(BigDecimal poPrice) {
        this.poPrice = poPrice;
    }



    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getStockQty() {
        return stockQty;
    }

    public void setStockQty(BigDecimal stockQty) {
        this.stockQty = stockQty;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }



    public BigDecimal getOpeningStock() {
        return openingStock;
    }

    public void setOpeningStock(BigDecimal openingStock) {
        this.openingStock = openingStock;
    }

    public BigDecimal getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(BigDecimal currentStock) {
        this.currentStock = currentStock;
    }

    public BigDecimal getSalesQty() {
        return salesQty;
    }

    public void setSalesQty(BigDecimal salesQty) {
        this.salesQty = salesQty;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getOldStock() {
        return oldStock;
    }

    public void setOldStock(BigDecimal oldStock) {
        this.oldStock = oldStock;
    }



    public String getUpcType() {
        return upcType;
    }

    public void setUpcType(String upcType) {
        this.upcType = upcType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(productId);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(sku);
        parcel.writeString(upc);
        parcel.writeString(uom);
        parcel.writeString(productCategory);
        parcel.writeInt(productCategoryId);
        parcel.writeString(isActive);
        parcel.writeString(upcType);
        parcel.writeInt(profileId);
        parcel.writeString(cwUom);
        parcel.writeString(String.valueOf(weight));
        parcel.writeString(String.valueOf(cwTolerance));
        parcel.writeString(String.valueOf(cwUomId));
        parcel.writeString(group1);
        parcel.writeString(String.valueOf(stdPrecision));
        parcel.writeString(String.valueOf(cwStdPrecision));
        parcel.writeString(unitOfMeasure.toString());
        parcel.writeString(cwUnitOfMeasure.toString());
    }




    protected ProductModel(Parcel in) {
        String myClass = in.readString(); // ignore the class name
        load(in);
    }

    protected void load(Parcel in) {
        productId = in.readInt();
        name = in.readString();
        description = in.readString();
        sku = in.readString();
        upc = in.readString();
        uom = in.readString();
        productCategory = in.readString();
        productCategoryId = in.readInt();
        isActive = in.readString();
        upcType = in.readString();
        profileId = in.readInt();
        cwUom = in.readString();
        weight = BigDecimal.valueOf(in.readInt());
        cwTolerance = BigDecimal.valueOf(in.readInt());
        cwUomId = BigDecimal.valueOf(in.readInt());
        group1 = in.readString();
        stdPrecision = in.readInt();
        cwStdPrecision =  in.readInt();
        unitOfMeasure = in.readString();
        cwUnitOfMeasure = in.readString();



    }
    // Subclass CREATOR will call this...
    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel source) {
            String myClass = source.readString(); // first thing
            try {
                ProductModel line = (ProductModel) Class.forName(myClass).newInstance();
                line.load(source);
                return line;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };
    public ProductModel() {
    }


}

class Converters {
    @TypeConverter
    public BigDecimal fromString(String value) {
        return value == null ? null : new BigDecimal(value);
    }

    @TypeConverter
    public Double amountToString(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        } else {
            return bigDecimal.doubleValue();
        }
    }
}

class JConverter {

    @TypeConverter
    public int toBigDecimal(String value) {
         int stdPrecision = 0;
        try {
            stdPrecision =  new JSONObject(value).getInt("stdPrecision");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  stdPrecision;
    }



}

