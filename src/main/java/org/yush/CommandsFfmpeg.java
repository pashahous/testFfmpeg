package org.yush;

public enum CommandsFfmpeg {
    /*

ffmpeg -hwaccel cuda -i 37M23S_1713433043.mp4 -vf scale=1280:720 -b:v 0.4M -c:v h264_nvenc 9nveng_gpuWithCUDA_04M.mp4
     */
    CUDA_SCALE1280_720_B_04M_H264_NVSNC("ffmpeg -hwaccel cuda -i %s -vf scale=1280:720 -b:v 0.4M -c:a aac -c:v h264_nvenc %s"
            ,"Перекодировка видео, а так же аудио(в удобный формат)"),
    SET_TITILE_AND_DESCRIPTION("ffmpeg -i %s -map_metadata 0 -metadata title=%s -metadata comment=%s -codec copy" +
            " %s","Добавление название видео и описания,Title and Description")
    ;//ffmpeg -i input_video.mp4 -c:v copy -c:a copy output_video.mp4


    private String comand;
    private String description;

    public String getDescription() {
        return description;
    }

    CommandsFfmpeg(String comand, String description) {
        this.comand = comand;
        this.description = description;
    }

    public String getComand() {
        return comand;
    }
}
