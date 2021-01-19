package com.zvonimirplivelic.hazardousdrinkinggame.ui.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import com.zvonimirplivelic.hazardousdrinkinggame.R

class GameFragment : Fragment() {

    private lateinit var ivFirstDice: ImageView
    private lateinit var ivSecondDice: ImageView

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivFirstDice = view.findViewById(R.id.ivFirstDice)
        ivSecondDice = view.findViewById(R.id.ivSecondDice)

        val btnRollDice: Button = view.findViewById(R.id.btnRollDices)
        btnRollDice.setOnClickListener { rollDices() }

        val infoBtn: ImageView = view.findViewById(R.id.ibInfo)
        infoBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.gameToInfo)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun rollDices() {
        ivFirstDice.setImageResource(setDrawableResource(generateRandomNumber()))
        ivSecondDice.setImageResource(setDrawableResource(generateRandomNumber()))
    }

    private fun setDrawableResource(diceValue: Int): Int {
        return when (diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun generateRandomNumber(): Int {
        return (1..6).random()
    }
}