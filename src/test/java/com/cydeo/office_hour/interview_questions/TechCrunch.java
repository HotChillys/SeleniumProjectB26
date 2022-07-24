package com.cydeo.office_hour.interview_questions;

import com.cydeo.test.base.TestBase;
import org.testng.annotations.Test;

public class TechCrunch extends TestBase {
    /*
        IQ : TECH CRUNCH

         Using any test automation framework, Java language (except record/play tools) and Maven dependency management, please do following:

        1- Go to https://techcrunch.com/
        2- For “The Latest News” list, verify followings;
            a. each news has an author
            b. each news has an image
        3- Click one of news from “The Latest News” list to reach the full content and verify followings;
            a. the browser title is the same with the news title
            b. the links within the news content
     */

    @Test
    public void techCrunch(){

        //Go to https://techcrunch.com/
        driver.get("https://techcrunch.com/");

        //For “The Latest News” list, verify followings;
        //            a. each news has an author
        //            b. each news has an image



    }



}
