package com.martnrico.berserker.utils;

import com.martnrico.berserker.data.network.model.Entry.EntryModel;
import com.martnrico.berserker.data.network.model.Entry.FooterEntryModel;
import com.martnrico.berserker.data.network.model.Entry.HeaderEntryModel;
import com.martnrico.berserker.data.network.model.ExerciseModel;
import com.martnrico.berserker.data.network.model.UserModel;
import com.martnrico.berserker.data.network.model.Entry.WodModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Martín Rico Martínez on 21/11/2018.
 */
public final class MockData {

    public static UserModel getMockUserModel() {
        UserModel userModel = new UserModel();
        userModel.setUserId(UUID.randomUUID().getLeastSignificantBits());
        userModel.setUserEmail("martin123@gmail.com");
        userModel.setUserName("Martin");
        userModel.setProfilePicUrl("");
        userModel.setRate(2);
        userModel.setRank("BEGINNER");
        return userModel;
    }

    public static EntryModel getMockEntryModel() {
        EntryModel entryModel = new EntryModel();
        entryModel.setUserModel(getMockUserModel());
        entryModel.setDate(Calendar.getInstance().getTimeInMillis());
        entryModel.setPlace("Bordeaux");
        HeaderEntryModel headerEntryModel = new HeaderEntryModel();
        WodModel wodModel = new WodModel();
        wodModel.setDate(Calendar.getInstance().getTimeInMillis());
        wodModel.setTypeWod("FOR TIME");
        headerEntryModel.setName("Martin Rico");
        headerEntryModel.setDate("5 de Diciembre");
        headerEntryModel.setPlaceName("Bordeaux");
        //wodModel.setTypeWod("For Time");
        List<String> exerciseList = new ArrayList<>();
        exerciseList.add("20 PULL-UPS");
        exerciseList.add("30 PUSH-UPS");
        exerciseList.add("40 SIT-UPS");
        exerciseList.add("50 AIR SQUATS");
        exerciseList.add("60 DV");
        exerciseList.add("200 METERS RUN");
        wodModel.setExerciseList(exerciseList);
        FooterEntryModel footerEntryModel = new FooterEntryModel();
        footerEntryModel.setLike(false);
        footerEntryModel.setTypeResult(false);
        footerEntryModel.setResultWod("15:30");
        List<String> mScaledList = new ArrayList<>();
        mScaledList.add("PULL-UPS ADAPTED");
        mScaledList.add("HANDSTAND PUSH-UP ADAPTED");
        footerEntryModel.setCommentsList(mScaledList);
        //entryModel.setHeaderEntryModel(headerEntryModel);
        entryModel.setWodModel(wodModel);
        //entryModel.setFooterEntryModel(footerEntryModel);
        return entryModel;
    }

    public static List<EntryModel> getEntryModelList() {
        List<EntryModel> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(getMockEntryModel());
        }
        return list;
    }

    public static List<ExerciseModel> getMockExercises() {
        List<ExerciseModel> exerciseList = new ArrayList<>();
        ExerciseModel exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Pull ups");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/n3X207Z/pull-ups.jpg");
        exerciseList.add(exerciseModel);

        exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Push ups");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/LNkMxKK/push-up.jpg");
        exerciseList.add(exerciseModel);

        exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Thrusters");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/cvmtTPr/Thusters.jpg");
        exerciseList.add(exerciseModel);

        exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Over Head Squat");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/nmTLrFh/ohs.jpg");
        exerciseList.add(exerciseModel);

        exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Run");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/J5Sftv5/ru.jpg");
        exerciseList.add(exerciseModel);

        exerciseModel = new ExerciseModel();
        exerciseModel.setDescription("Lorem ipsum dolor sit amet consectetur adipiscing elit risus posuere, quisque et fusce inceptos mi ad justo congue");
        exerciseModel.setName("Double Unders");
        exerciseModel.setUrlBackgroundImg("https://i.ibb.co/5MwghDs/du.jpg");
        exerciseList.add(exerciseModel);

        return exerciseList;
    }
}
