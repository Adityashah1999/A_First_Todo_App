package com.aditya.android_todo_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;
    private TextView TodoTextView;
    /* In case of state change, such as rotating the phone,
       store the mTodoIndex */
    private static final String TODO_INDEX = "com.example.android_todo_first.todoIndex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null){
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todos);
        setContentView(R.layout.activity_todo);
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);
        TodoTextView.setText(mTodos[mTodoIndex]);

        /* setup navigation buttons */
        /* next button to cycle through mTodos */
        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);

        /* OnClick listener for the  Next button */
        buttonNext.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        //check index boundary for mTodos
                        if (mTodoIndex < mTodos.length - 1) {
                            mTodoIndex += 1;
                        } else {
                            mTodoIndex = 0;
                        }


                        //   mTodoIndex += 1;
                        TodoTextView.setText(mTodos[mTodoIndex]);
                    }
                });

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mTodoIndex = savedInstanceState.getInt(TODO_INDEX);
        TodoTextView.setText(mTodos[mTodoIndex]);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(TODO_INDEX, mTodoIndex);
        super.onSaveInstanceState(savedInstanceState);
    }

}