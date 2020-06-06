package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise extends AppCompatActivity {
    int gender,level,exercise_no;
    String exercise_type;
    long maxTimeInMilliseconds;

    TextView description , timer_text , title;
    ImageView image;
    Button start_timer,reset_timer,prev_exer,next_exer;

    CountDownTimer t;

    Integer[] male_abs_name = {
            R.string.male_abs_easy_hindupushup,
            R.string.male_abs_easy_hipraises,
            R.string.male_abs_easy_inchworm,
            R.string.male_abs_easy_plank,
            R.string.male_abs_medium_alternate_heal_touches,
            R.string.male_abs_medium_bench_leg_pull_in,
            R.string.male_abs_medium_jackknife_situps,
            R.string.male_abs_medium_sideplank,
            //R.string.male_abs_hard_dbl_side_jack,
            R.string.male_abs_hard_dumbbell_side_bend,
            //R.string.male_abs_hard_dumbell_chop,
            R.string.male_abs_hard_russian_twist,
    };
    Integer[] male_abs_description = {
            R.string.abs_easy_hindupushup,
            R.string.abs_easy_hipraises,
            R.string.abs_easy_inchworm,
            R.string.abs_easy_plank,
            R.string.abs_medium_alternate_heal_touches,
            R.string.abs_medium_bench_leg_pull_in,
            R.string.male_abs_medium_jackknife_situps,
            R.string.male_abs_medium_sideplank,
            //R.string.abs_hard_dbl_side_jack,
            R.string.abs_hard_dumbbell_side_bend,
            //R.string.abs_hard_dumbell_chop,
            R.string.abs_hard_russian_twist,
    };
    Integer[] male_abs_image ={
            R.drawable.abs_easy_hindupushup,
            R.drawable.abs_easy_hipraises,
            R.drawable.abs_easy_inchworm,
            R.drawable.abs_easy_plank,
            R.drawable.abs_medium_alternate_heal_touches,
            R.drawable.abs_medium_bench_leg_pull_in,
            R.drawable.abs_medium_jackknife_situps,
            R.drawable.abs_medium_sideplank,
            R.drawable.abs_hard_dumbbell_side_bend,
            //R.drawable.abs_hard_dumbell_chop,
            R.drawable.abs_hard_russian_twist,
    };


    Integer[] male_up_name = {
            R.string.male_up_hard_hammer_grip_pull_up_n,
            R.string.male_up_easy_tricep,
            R.string.male_up_hard_wide_grip_pull_ups,
            //R.string.male_up_medium_chinups,
            R.string.male_up_medium_close_grip_pull_up,
            R.string.male_up_easy_triceps_extension,
            R.string.male_up_easy_bicep_curl,
    };
    Integer[] male_up_description = {
            R.string.up_hard_hammer_grip_pull_up_n,
            R.string.up_easy_tricep,
            R.string.up_hard_wide_grip_pull_ups,
            //R.string.up_medium_chinups,
            R.string.up_medium_close_grip_pull_up,
            R.string.up_easy_triceps_extension,
            //R.string.up_easy_bicep_curl,


    };
    Integer[] male_up_image = {
            R.drawable.up_hard_hammer_grip_pull_up_n,
            R.drawable.up_easy_tricep,
            R.drawable.up_hard_wide_grip_pull_ups,
            //R.drawable.up_medium_chinups,
            R.drawable.up_medium_close_grip_pull_up,
            R.drawable.up_easy_triceps_extension,
           // R.drawable.up_easy_bicep_curl,


    };


    Integer[] male_lb_name ={
            R.string.male_fb_easy_bodyweight_squats,
            R.string.male_fb_easy_knee_push_ups,
            //R.string.male_fb_easy_planks_n,
            R.string.male_fb_easy_jumping_jacks,
            //R.string.male_fb_medium_crunches,
            //R.string.male_fb_medium_donkey_kicks,
            //R.string.male_fb_medium_mountain_climbers,
            R.string.male_fb_hard_burpees,
            R.string.male_fb_hard_clap_push_ups,
            R.string.male_fb_hard_split_alternating_squat_jumps,
    };
    Integer[] male_lb_image = {
            R.drawable.fb_easy_bodyweight_squats,
            R.drawable.fb_easy_knee_push_ups,
            R.drawable.abs_easy_plank,
            R.drawable.fb_easy_jumping_jacks,
            R.drawable.fb_medium_crunches,
            R.drawable.fb_medium_donkey_kicks,
            R.drawable.fb_medium_mountain_climbers,
            R.drawable.fb_hard_burpees,
            R.drawable.fb_hard_clap_push_ups,
            R.drawable.fb_hard_split_alternating_squat_jumps,
    };
    Integer[] male_lb_description ={
            R.string.fb_easy_bodyweight_squats,
            R.string.fb_easy_knee_push_ups,
            //R.string.fb_easy_planks_n,
            R.string.fb_easy_jumping_jacks,
            //R.string.fb_medium_crunches,
            //R.string.fb_medium_donkey_kicks,
            //R.string.fb_medium_mountain_climbers,
            R.string.fb_hard_burpees,
            R.string.fb_hard_clap_push_ups,
            R.string.fb_hard_split_alternating_squat_jumps,
    };

    Integer[] male_fb_name ={
            R.string.male_lb_easy_calf_raises,
            R.string.male_lb_easy_wall_sit,
            //R.string.male_lb_easy_pilates,
            R.string.male_lb_medium_jump_squats,
            R.string.male_lb_medium_mountain_climbers,
            R.string.male_lb_medium_walking_lunge,
            R.string.male_lb_hard_dumbell_squats,
            //R.string.male_lb_hard_swiss_ball_leg_lifts,
            //R.string.male_lb_hard_lunge_twist,
    };
    Integer[] male_fb_image ={
            R.drawable.lb_easy_calf_raises,
            R.drawable.lb_easy_wall_sit,
            //R.drawable.lb_easy_pilates,
            R.drawable.lb_medium_jump_squats,
            R.drawable.lb_medium_mountain_climbers,
            R.drawable.lb_medium_walking_lunge,
            R.drawable.lb_hard_dumbell_squats,
            //R.drawable.lb_hard_swiss_ball_leg_lifts,
            //R.drawable.lb_hard_lunge_twist,
    };
    Integer[] male_fb_description ={
            R.string.lb_easy_calf_raises,
            R.string.lb_easy_wall_sit,
            //R.string.lb_easy_pilates,
            R.string.lb_medium_jump_squats,
            R.string.lb_medium_mountain_climbers,
            R.string.lb_medium_walking_lunge,
            R.string.lb_hard_dumbell_squats,
            //R.string.lb_hard_swiss_ball_leg_lifts,
            //R.string.lb_hard_lunge_twist,
    };


    Integer[] female_abs_name = {
            R.string.fm_abs_easy_abdominal_crunches,
            R.string.fm_abs_easy_leg_raises,
            R.string.fm_abs_easy_plank,
            R.string.fm_abs_easy_sit_ups,
            //R.string.fm_abs_medium_abdominal_crunches,
            //R.string.fm_abs_medium_plank,
            //R.string.fm_abs_medium_side_plank_right,
            R.string.fm_abs_medium_side_plank_left,
            //R.string.f_abs_hard_abdominal_crunches,
            R.string.fm_abs_hard_cobras,
            R.string.fm_abs_medium_reverse_crunches,
    };
    Integer[] female_abs_image = {
            R.drawable.f_abs_easy_abdominal_crunches,
            R.drawable.f_abs_easy_leg_raises,
            R.drawable.f_abs_easy_plank,
            R.drawable.f_abs_easy_sit_ups,
            //R.drawable.f_abs_medium_abdominal_crunches,
            //R.drawable.f_abs_medium_plank,
            //R.drawable.f_abs_medium_side_plank_right,
            R.drawable.f_abs_medium_side_plank_left,
            //R.drawable.f_abs_hard_abdominal_crunches,
            R.drawable.f_abs_hard_cobras,
            R.drawable.f_abs_medium_reverse_crunches,
    };
    Integer[] female_abs_description = {
            R.string.abdominal_crunches,
            R.string.leg_raises,
            R.string.plank,
            R.string.sit_ups,
            //R.string.abdominal_crunches,
            //R.string.medium_plank,
            //R.string.side_plank_right,
            R.string.plank,
            //R.string.f_abs_hard_abdominal_crunches,
            R.string.cobras,
            R.string.reverse_crunches,
    };

    Integer[] female_up_name = {
            R.string.fm_up_hard_mountain_climber,
            R.string.fm_up_hard_mountain_climber,
            //R.string.fm_up_easy_mountain_climber,
            R.string.fm_up_easy_plank,
            R.string.fm_up_easy_push_ups,
            R.string.fm_up_easy_tricep_dips,
            R.string.fm_up_medium_arm_circles,
            //R.string.fm_up_medium_push_ups,
            //R.string.fm_up_medium_tricep_dips,
            //R.string.fm_up_medium_arm_circles,
            //R.string.fm_up_hard_arm_circles,
            //R.string.fm_up_hard_mountain_climber,
            //R.string.fm_up_hard_plank,
            //R.string.fm_up_hard_tricep_dips,
    };
    Integer[] female_up_image = {
            R.drawable.f_up_hard_mountain_climber,
            R.drawable.f_up_hard_mountain_climber,
            //R.drawable.f_up_easy_mountain_climber,
            R.drawable.f_up_easy_plank,
            R.drawable.f_up_easy_push_ups,
            R.drawable.f_up_easy_tricep_dips,
            R.drawable.f_up_medium_arm_circles,
            //R.drawable.f_up_medium_push_ups,
            //R.drawable.f_up_medium_tricep_dips,
            //R.drawable.f_up_medium_arm_circles,
            //R.drawable.f_up_hard_arm_circles,
            //R.drawable.f_up_hard_mountain_climber,
            //R.drawable.f_up_hard_plank,
            //R.drawable.f_up_hard_tricep_dips,
    };
    Integer[] female_up_description = {
            R.string.mountain_climber,
            R.string.mountain_climber,
            //R.string.mountain_climber,
            R.string.plank,
            R.string.push_ups,
            R.string.tricep_dips,
            R.string.arm_circles,
            //R.string.push_ups,
            //R.string.tricep_dips,
            //R.string.arm_circles,
            //R.string.arm_circles,
            //R.string.mountain_climber,
            //R.string.hard_plank,
            //R.string.tricep_dips,
    };
    Integer[] female_lb_name = {
            R.string.fm_lb_easy_side_lying_leg_lift_up_left,
            //R.string.fm_lb_easy_left_lying_lift_up_right,
            R.string.fm_lb_easy_plie_squats,
            R.string.fm_lb_easy_wall_sit,
            R.string.fm_lb_medium_left_lunge_knee_hops,
            //R.string.fm_lb_medium_right_lunge_knee_hops,
            R.string.fm_lb_medium_sumo_squat_calf_raises,
            //R.string.fm_lb_medium_wall_sit,
            R.string.fm_lb_hard_bulgarian_squat,
            R.string.fm_lb_hard_crusty_lunges,
    };
    Integer[] female_lb_image = {
            R.drawable.f_lb_easy_side_lying_leg_lift_up_left,
            //R.drawable.f_lb_easy_left_lying_lift_up_right,
            R.drawable.f_lb_easy_plie_squats,
            R.drawable.f_lb_easy_wall_sit,
            R.drawable.f_lb_medium_left_lunge_knee_hops,
            //R.drawable.f_lb_medium_right_lunge_knee_hops,
            R.drawable.f_lb_medium_sumo_squat_calf_raises,
            //R.drawable.f_lb_medium_wall_sit,
            R.drawable.f_lb_hard_bulgarian_squat,
            R.drawable.f_lb_hard_crusty_lunges,
    };
    Integer[] female_lb_description = {
            R.string.side_lying_leg_lift_up,
            //R.string.left_lying_lift_up,
            R.string.plie_squats,
            R.string.wall_sit,
            R.string.lunge_knee_hops,
            //R.string.lunge_knee_hops,
            R.string.sumo_squat_calf_raises,
            //R.string.wall_sit,
            R.string.bulgarian_squat,
            R.string.crusty_lunges,
    };

    Integer[] female_fb_name = {
            R.string.fm_fb_easy_abdominal_crunches,
            R.string.fm_fb_easy_jumping_jack,
            R.string.fm_fb_easy_plank,
            R.string.fm_fb_hard_step_up_onto_chair,
            //R.string.fm_fb_medium_cross_arm_lunges,
            R.string.fm_fb_medium_crusty_lunges,
            R.string.fm_fb_medium_knee_push_ups,
            R.string.fm_up_easy_push_ups,
            //R.string.fm_fb_medium_side_plank_left,
            //R.string.fm_fb_medium_side_plank_right,
            //R.string.fm_fb_hard_high_stepping,
            //R.string.fm_fb_hard_kneepushups,
            // R.string.fm_fb_hard_side_plank_right,
            R.string.fm_fb_hard_sideplankleft,
            R.string.fm_fb_hard_step_up_onto_chair,
    };
    Integer[] female_fb_image = {
            R.drawable.f_fb_easy_abdominal_crunches,
            R.drawable.f_fb_easy_jumping_jack,
            R.drawable.f_fb_easy_plank,
            R.drawable.f_fb_hard_step_up_onto_chair,
            //R.drawable.f_fb_medium_cross_arm_lunges,
            R.drawable.f_fb_medium_crusty_lunges,
            R.drawable.f_fb_medium_knee_push_ups,
            R.drawable.f_up_easy_push_ups,
            //R.drawable.f_fb_medium_side_plank_left,
            //R.drawable.f_fb_medium_side_plank_right,
            //R.drawable.f_fb_hard_high_stepping,
            //R.drawable.f_fb_hard_kneepushups,
           // R.drawable.f_fb_hard_side_plank_right,
            R.drawable.f_fb_hard_sideplankleft,
            R.drawable.f_fb_hard_step_up_onto_chair,

    };
    Integer[] female_fb_description = {
            R.string.abdominal_crunches,
            R.string.jumping_jack,
            R.string.plank,
            R.string.step_up_onto_chair,
            //R.string.cross_arm_lunges,
            R.string.crusty_lunges,
            R.string.knee_push_ups,
            R.string.push_ups,
            //R.string.plank,
            //R.string.plank,
            //R.string.high_stepping,
            //R.string.kneepushups,
            // R.string.plank,
            R.string.plank,
            R.string.step_up_onto_chair,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        title = findViewById(R.id.final_txt1);
        image = findViewById(R.id.ex_img);
        description = findViewById(R.id.description);
        timer_text = findViewById(R.id.timer_txt);
        start_timer = findViewById(R.id.timer_start);
        reset_timer = findViewById(R.id.timer_reset);
        prev_exer = findViewById(R.id.previous_exe);
        next_exer = findViewById(R.id.next_exe);

        Intent intent = getIntent();
        gender = intent.getIntExtra("gender",1);
        exercise_type = intent.getStringExtra("exercise type");
        level = intent.getIntExtra("level",1);
        exercise_no = intent.getIntExtra("ex_num",1);


        if(level==1)
        {
            maxTimeInMilliseconds = 30000; // set timer
            timer_text.setText("0:30");
        }
        else if(level==2)
        {
            maxTimeInMilliseconds = 45000; // set timer
            timer_text.setText("0:45");
        }
        else if(level==3)
        {
            maxTimeInMilliseconds = 60000; // set timer
            timer_text.setText("1:0");
        }

        next_exer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = null;
                if(exercise_no!=5)
                {
                    i = new Intent(Exercise.this,Exercise.class);
                    i.putExtra("gender",gender);
                    i.putExtra("exercise type",exercise_type);
                    i.putExtra("level",level);
                    exercise_no = exercise_no + 1;
                    i.putExtra("ex_num",exercise_no);
                }
                else if(exercise_no==5)
                {
                    i = new Intent(Exercise.this,Main3Activity.class);
                    i.putExtra("gender",gender);
                }
                startActivity(i);
                finish();
            }
        });

        prev_exer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = null;
                if(exercise_no!=1)
                {
                    i = new Intent(Exercise.this,Exercise.class);
                    i.putExtra("gender",gender);
                    i.putExtra("exercise type",exercise_type);
                    i.putExtra("level",level);
                    exercise_no = exercise_no - 1;
                    i.putExtra("ex_num",exercise_no);

                }
                else if(exercise_no==1)
                {
                    i = new Intent(Exercise.this,Main3Activity.class);
                    i.putExtra("gender",gender);
                }
                startActivity(i);
                finish();
            }
        });

        start_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startTimer(maxTimeInMilliseconds, 1000);
            }
        });
        reset_timer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                t.cancel();
                if(level==1)
                {
                    timer_text.setText("0:30");
                }
                else if(level==2)
                {
                    timer_text.setText("0:45");
                }
                else if(level==3)
                {
                    timer_text.setText("1:0");
                }
            }
        });

        if(gender==1)
        {
            if(exercise_type.equals("Abs workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Male , Abs workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(male_abs_name[exercise_no]);
                image.setImageResource(male_abs_image[exercise_no]); // set image
                description.setText(male_abs_description[exercise_no]); // set description
            }
            else if(exercise_type.equals("Upper Body workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Male , Upper Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(male_up_name[exercise_no]);
                image.setImageResource(male_up_image[exercise_no]); // set image
                description.setText(male_up_description[exercise_no]); // set description
            }
            else if(exercise_type.equals("Lower Body workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Male , Lower Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(male_lb_name[exercise_no]);
                image.setImageResource(male_lb_image[exercise_no]); // set image
                description.setText(male_lb_description[exercise_no]); // set description
            }
            else
            {
                //Toast.makeText(getApplicationContext(), "Gender: Male , Full Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(male_fb_name[exercise_no]);
                image.setImageResource(male_fb_image[exercise_no]); // set image
                description.setText(male_fb_description[exercise_no]); // set description
            }
        }
        else
        {
            if(exercise_type.equals("Abs workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Female , Abs workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(female_abs_name[exercise_no]);
                image.setImageResource(female_abs_image[exercise_no]); // set image
                description.setText(female_abs_description[exercise_no]); // set description
            }
            else if(exercise_type.equals("Upper Body workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Female , Upper Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(female_up_name[exercise_no]);
                image.setImageResource(female_up_image[exercise_no]); // set image
                description.setText(female_up_description[exercise_no]); // set description
            }
            else if(exercise_type.equals("Lower Body workout"))
            {
                //Toast.makeText(getApplicationContext(), "Gender: Female , Lower Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(female_lb_name[exercise_no]);
                image.setImageResource(female_lb_image[exercise_no]); // set image
                description.setText(female_lb_description[exercise_no]); // set description
            }
            else
            {
                //Toast.makeText(getApplicationContext(), "Gender: Female , Full Body workout "+level+" "+exercise_no, Toast.LENGTH_SHORT).show();
                title.setText(female_fb_name[exercise_no]);
                image.setImageResource(female_fb_image[exercise_no]); // set image
                description.setText(female_fb_description[exercise_no]); // set description
            }
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void startTimer(final long finish, long tick) {
        //CountDownTimer t;
        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                timer_text.setText("" + (remainedSecs / 60) + ":" + (remainedSecs % 60));// manage it accordign to you
            }

            public void onFinish() {
                timer_text.setText("00:00");
                Toast.makeText(Exercise.this, "Finish", Toast.LENGTH_SHORT).show();
                cancel();
            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bmi_calc:
                Intent i0 = new Intent(Exercise.this, BMI.class);
                startActivity(i0);
                break;
            case R.id.feedback:
                Intent i1 = new Intent(Exercise.this, Feedback.class);
                startActivity(i1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
