package com.example.carol.bucketlistfam;

/**
 * Created by carol on 10/6/17.
 */

public class Story {


        private String Title;
        private String Story;

    public Story (){};

        public Story(String title, String story) {
            this.Title=title;
            this.Story=story;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getStory() {
            return Story;
        }

        public void setStory(String story) {
            Story = story;
        }

}
