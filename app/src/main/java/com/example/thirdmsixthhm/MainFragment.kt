package com.example.thirdmsixthhm

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thirdmsixthhm.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lesson = Lesson()
        binding.addLesson.setOnClickListener {
            if (binding.lessonName.text.isNotEmpty()) {
                lesson.lesson = binding.lessonName.text.toString()
                val bundle = Bundle()
                bundle.putSerializable("lesson", lesson)
                val lessonFragment = LessonFragment()
                lessonFragment.arguments = bundle
                requireActivity().replaceFragment(lessonFragment)
            } else {
                showToast("Name filed can not be empty")
            }
        }

        binding.lessonBcg.setOnClickListener {
            showAlert("Choose background", R.array.background) { pos ->
                val name = resources.getStringArray(R.array.background).get(pos)
                binding.lessonBcg.setText(name)
                when (pos) {
                    0 -> {
                        lesson.color = R.color.red
                    }
                    1 -> {
                        lesson.color = R.color.orange
                    }
                    2 -> {
                        lesson.color = R.color.blue
                    }
                }
            }

        }

        binding.lessonImage.setOnClickListener {
            var url = ""
            showAlert("Choose image",R.array.images){pos ->
                when (pos) {
                    0 -> {
                        url =
                            "https://upload.wikimedia.org/wikipedia/commons/c/c3/Deus_mathematics.png"
                    }
                    1 -> {
                        url = "https://www.pngall.com/wp-content/uploads/9/History-Book.png"
                    }
                    2 -> {
                        url =
                            "https://upload.wikimedia.org/wikipedia/commons/7/7b/WikiProject_Biology_Logo_%28Deus_WikiProject%29.png"
                    }
                }
                lesson.image = url
                binding.lessonImage.setText(url)
            }
        }
    }
}