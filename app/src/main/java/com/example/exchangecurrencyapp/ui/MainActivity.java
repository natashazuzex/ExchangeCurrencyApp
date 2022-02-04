package com.example.exchangecurrencyapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.exchangecurrencyapp.R;
import com.example.exchangecurrencyapp.databinding.ActivityMainBinding;
import com.example.exchangecurrencyapp.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sourceSpinner.setAdapter(adapter);
        binding.finalSpinner.setAdapter(adapter);

        observeFinalAmount();
        binding.btnOk.setOnClickListener(v ->
                convertCurrency(
                        binding.sourceSpinner.getSelectedItem().toString(),
                        binding.finalSpinner.getSelectedItem().toString(),
                        binding.sourceEdit.getText().toString()
                )
        );
    }

    private void convertCurrency(String from, String to, String sumString) {
        if (!sumString.isEmpty()) {
            double sum = Double.parseDouble(sumString);
            mainViewModel.onOkClicked(from, to, sum);
        }
    }

    private void observeFinalAmount() {
        mainViewModel.getFinalAmount().observe(this, binding.finalEdit::setText);
    }
}