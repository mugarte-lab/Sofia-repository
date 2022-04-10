package com.example.trab1progmov;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trab1progmov.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private Spinner spinner;
    private MediaPlayer mediaPlayer;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);
        View view=binding.getRoot();
        spinner=view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int pos, long l) {
                if(mediaPlayer!=null){
                    mediaPlayer.release();
                }
                switch (pos){
                    case 1:
                        mediaPlayer=mediaPlayer.create(getContext(),R.raw.digitalbell);
                        mediaPlayer.start();
                        break;
                    case 2:
                        mediaPlayer=mediaPlayer.create(getContext(),R.raw.claps);
                        mediaPlayer.start();
                        break;
                    case 3:
                        mediaPlayer=mediaPlayer.create(getContext(),R.raw.vibracaocelul);
                        mediaPlayer.start();
                        break;
                    case 4:
                        mediaPlayer=mediaPlayer.create(getContext(),R.raw.estalardedos);
                        mediaPlayer.start();
                        break;
                }
                if(mediaPlayer!=null){
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}