package com.testukr.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VariantActivity extends AppCompatActivity {

    int currentQuestion = 0;
    int score = 0;
    final int TOTAL = 12;

    String[][] questions = {
        {
            "У якому слові спрощення НЕ відбувається ні на письмі, ні у вимові?",
            "Чесний", "Тиснути", "Хворостняк", "Обласний"
        },
        {
            "Який іменник у родовому відмінку має закінчення -у?",
            "Клен", "Париж", "Папір", "Документ"
        },
        {
            "Оберіть правильний варіант написання слова з пів-:",
            "Пів-Києва", "Пів яблука", "Пів аркуша", "Півострів"
        },
        {
            "Визначте тип підмета: «Чумацький Шлях освічував нічну дорогу»",
            "Простий", "Складений", "Неозначений", "Узагальнений"
        },
        {
            "У якому прикметнику пишеться подвоєна літера НН?",
            "Глиняний", "Священний", "Лебединий", "Шалений"
        },
        {
            "З яким іменником числівник «два» узгоджується у формі множини?",
            "Професори", "Кілограм", "Будинок", "Студент"
        },
        {
            "Яке словосполучення є калькою з російської і вважається помилкою?",
            "Брати участь", "Здати іспит", "Приймати міри", "Протягом року"
        },
        {
            "Після якого префікса перед я, ю, є, ї пишеться апостроф?",
            "На-", "З-", "При-", "За-"
        },
        {
            "Яким засобом поєднані частини: «Я знаю, що сонце встане»?",
            "Сполучник сурядності", "Сполучник підрядності",
            "Сполучне слово (займенник)", "Сполучне слово (прислівник)"
        },
        {
            "До якої дієвідміни належить дієслово «бачити»?",
            "Перша дієвідміна", "Друга дієвідміна",
            "Мішана дієвідміна", "Особлива група"
        },
        {
            "Яке з цих слів пишеться через дефіс?",
            "Лісостеп", "Кінотеатр", "Віце-президент", "Жовтогарячий"
        },
        {
            "Для якого стилю характерні кліше, штампи, канцеляризми?",
            "Публіцистичний", "Офіційно-діловий", "Художній", "Науковий"
        }
    };

    int[] correct = {2, 2, 2, 1, 1, 0, 2, 1, 1, 1, 2, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variant);

        showQuestion();

        Button b1 = findViewById(R.id.btnAns1);
        Button b2 = findViewById(R.id.btnAns2);
        Button b3 = findViewById(R.id.btnAns3);
        Button b4 = findViewById(R.id.btnAns4);

        b1.setOnClickListener(v -> checkAnswer(0));
        b2.setOnClickListener(v -> checkAnswer(1));
        b3.setOnClickListener(v -> checkAnswer(2));
        b4.setOnClickListener(v -> checkAnswer(3));
    }

    void showQuestion() {
        TextView tvTitle = findViewById(R.id.tvVariantTitle);
        TextView tvNum = findViewById(R.id.tvQuestionNum);
        TextView tvQ = findViewById(R.id.tvQuestion);
        Button b1 = findViewById(R.id.btnAns1);
        Button b2 = findViewById(R.id.btnAns2);
        Button b3 = findViewById(R.id.btnAns3);
        Button b4 = findViewById(R.id.btnAns4);

        tvTitle.setText("ТЕСТ");
        tvNum.setText("Питання " + (currentQuestion + 1) + " з " + TOTAL);
        tvQ.setText(questions[currentQuestion][0]);
        b1.setText("1. " + questions[currentQuestion][1]);
        b2.setText("2. " + questions[currentQuestion][2]);
        b3.setText("3. " + questions[currentQuestion][3]);
        b4.setText("4. " + questions[currentQuestion][4]);
    }

    void checkAnswer(int chosen) {
        if (chosen == correct[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        if (currentQuestion < TOTAL) {
            showQuestion();
        } else {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("total", TOTAL);
            startActivity(intent);
            finish();
        }
    }
}
