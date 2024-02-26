package com.example.lessonsapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonsapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private var questionList = emptyList<Question>()
    private var activeQuestionId = 0
    private lateinit var preferences: SharedPreferences

    companion object {
        const val PREFERENCES_NAME = "ashe728y9e2h387"
        const val KEY_LEVEL = "qi92ye9y2"
        const val KEY_APP_TYPE = "9u23e92klasfdsv"
        const val KEY_FAVORITE_PROGRAMMING_LANGUAGE = "9y8239d23"
        const val KEY_LEARN = "098sd8f7hifh984"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicia as preferências
        preferences = getSharedPreferences(MainActivity.PREFERENCES_NAME, MODE_PRIVATE)

        // Inicia o binding
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Criar lista de questões
        questionList = listOf(
            Question(
                1,
                getString(R.string.option_1),
                resources.getStringArray(R.array.options_1).toList(),
            ),
            Question(
                2,
                getString(R.string.option_2),
                resources.getStringArray(R.array.options_2).toList(),
            ),
            Question(
                3,
                getString(R.string.option_3),
                resources.getStringArray(R.array.options_3).toList(),
            ),
            Question(
                4,
                getString(R.string.option_4),
                resources.getStringArray(R.array.options_4).toList(),
            ),
        )

        // Coloca a primeira questão
        setQuestion(0)

        // Adiciona clique do botão Next
        with(binding) {
            bNext.setOnClickListener {

                if (activeQuestionId < questionList.size - 1) {
                    // Submete a resposta
                    val option = rgOptionsContainer.checkedRadioButtonId
                    submitAnswer(getRadioButtonId(option))
                }
                else {
                    // Próxima Activity
                    goToNextActivity()
                }
            }
        }
    }

    private fun setQuestion(questionId: Int) {
        if (questionId < questionList.size) {
            // Questão atual
            val currentQuestion = questionList[questionId]

            binding.apply {
                // Altera o enunciado
                tvQuestion.text = currentQuestion.question

                // Altera as opções
                rbOption1.text = currentQuestion.optionsList[0]
                rbOption2.text = currentQuestion.optionsList[1]
                rbOption3.text = currentQuestion.optionsList[2]
                rbOption4.text = currentQuestion.optionsList[3]

                // Limpa o check do RadioGroup
                rgOptionsContainer.clearCheck()
            }
        }

        if (activeQuestionId == questionList.size - 1) {
            // Altera botão ao chegar no final
            binding.bNext.text = getString(R.string.button_finish)
        }
    }

    private fun submitAnswer(optionId: Int) {
        // Obtém a resposta
        val currentQuestion = questionList[activeQuestionId]
        val submittedOption = currentQuestion.optionsList[optionId]


        // Salva resposta nas preferências
        saveToPrefs(
            getSharedPrefsKey(activeQuestionId),
            submittedOption
        )



        // Muda para próxima questão
        if (activeQuestionId < questionList.size) {
            activeQuestionId++
            setQuestion(activeQuestionId)
        }
    }

    private fun getRadioButtonId(buttonId: Int): Int =
        when(buttonId) {
            R.id.rbOption1 -> 0
            R.id.rbOption2 -> 1
            R.id.rbOption3 -> 2
            else -> 3
        }

    private fun goToNextActivity() {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }

    private fun getSharedPrefsKey(questionId: Int): String =
        when(questionId) {
            0 -> KEY_LEVEL
            1 -> KEY_FAVORITE_PROGRAMMING_LANGUAGE
            2 -> KEY_LEARN
            else -> KEY_APP_TYPE
        }

    private fun saveToPrefs(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }
}