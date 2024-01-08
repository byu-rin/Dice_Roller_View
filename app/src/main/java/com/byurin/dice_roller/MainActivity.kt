package com.byurin.dice_roller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byurin.dice_roller.databinding.ActivityMainBinding

/**
 * 주사위를 굴리고 화면에 결과를 띄움.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollBtn.setOnClickListener {rollDice() }

    }
    /**
     * 주사위를 굴리고 결과로 화면을 업데이트
     */
    private fun rollDice() {
        // 6면체 주사위 객체 생성
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // 결과를 화면에 업데이트
        binding.resultTv.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}