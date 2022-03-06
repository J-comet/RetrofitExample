package hs.project.retrofitexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import hs.project.retrofitexample.R
import hs.project.retrofitexample.adapter.ImageAdapter.ImageHolder
import hs.project.retrofitexample.data.photo.UrlsX
import hs.project.retrofitexample.databinding.ItemImgSearchBinding

class ImageAdapter(context: Context) : RecyclerView.Adapter<ImageHolder>() {

    private val mContext = context
    var list = arrayListOf<UrlsX>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_img_search, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            Toast.makeText(mContext, "$position 번째 선택", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = list.size


    fun setData(itemList: ArrayList<UrlsX>) {
        if (list != null) {
            list = arrayListOf()
        }
        list = itemList
        notifyDataSetChanged()
    }


    inner class ImageHolder(private val itemBinding: ItemImgSearchBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: UrlsX) {
            itemBinding.urlsX = item
        }
    }
}