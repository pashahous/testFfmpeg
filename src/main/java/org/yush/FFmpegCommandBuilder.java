package org.yush;

public class  FFmpegCommandBuilder {

    private String inputFileName;
    private String outputFileName;
    private String hwAccel;
    private String codec;
    private String resolution;

    public FFmpegCommandBuilder setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
        return this;
    }

    public FFmpegCommandBuilder setResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public FFmpegCommandBuilder setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
        return this;
    }

    public FFmpegCommandBuilder setHwAccel(String hwAccel) {
        this.hwAccel = hwAccel;
        return this;
    }

    public FFmpegCommandBuilder setCodec(String codec) {
        this.codec = codec;
        return this;
    }

    public String build() {
        if (inputFileName == null) {
            throw new IllegalStateException("Не все обязательные параметры были установлены.");
        }
//-vf scale=1280:720
        // Если имя выходного файла не задано, используем такое же как и входного файла
        if (outputFileName == null) {
            // Получаем расширение входного файла
            String extension = "";
            int lastDotIndex = inputFileName.lastIndexOf('.');
            if (lastDotIndex > 0) {
                extension = inputFileName.substring(lastDotIndex);
            }
            outputFileName = inputFileName.replace(extension, "_output.mp4");
        }

        return String.format("ffmpeg -hwaccel %s -i %s -c:v %s %s", hwAccel, inputFileName, codec, outputFileName);

    }
}
