package com.example.thirdmsixthhm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thirdmsixthhm.databinding.ItemLessonBinding

class LessonAdapter(private val data:ArrayList<Lesson>, private val onClick: (pos:Int)->Unit) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(ItemLessonBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    override fun getItemCount(): Int = data.size

    inner class LessonViewHolder(private var binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson) {
            binding.lesson.text = lesson.lesson
            lesson.color?.let { itemView.context.getColor(it) }
                ?.let { binding.mainLayout.setBackgroundColor(it) }
            binding.image.loadImage(lesson.image.toString())
        }

    }
}