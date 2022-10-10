package com.androiddevs.mvvmnewsapp.models


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(
    tableName = "articles"
)
@Parcelize
data class Article(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @SerializedName("author")
    var author: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("source")
    var source: Source?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    var urlToImage: String?
) : Parcelable