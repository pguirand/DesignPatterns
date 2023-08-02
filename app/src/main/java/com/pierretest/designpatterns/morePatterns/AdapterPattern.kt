package com.pierretest.designpatterns.morePatterns

// Existing AudioPlayer interface
interface AudioPlayer {
    fun playAudio(audioType: String, fileName: String)
}

// Concrete implementation of AudioPlayer
class SimpleAudioPlayer : AudioPlayer {
    override fun playAudio(audioType: String, fileName: String) {
        if (audioType.equals("mp3", ignoreCase = true)) {
            println("Playing mp3 file: $fileName")
        } else {
            println("Unsupported audio format")
        }
    }
}

// New AdvancedAudioPlayer interface (Different interface)
interface AdvancedAudioPlayer {
    fun playMp4(fileName: String)
    fun playWav(fileName: String)
}

// Concrete implementation of AdvancedAudioPlayer
class AdvancedAudioPlayerImpl : AdvancedAudioPlayer {
    override fun playMp4(fileName: String) {
        println("Playing mp4 file: $fileName")
    }

    override fun playWav(fileName: String) {
        println("Playing wav file: $fileName")
    }
}

// Adapter to make AdvancedAudioPlayer work with AudioPlayer interface
class AdvancedAudioPlayerAdapter(private val advancedAudioPlayer: AdvancedAudioPlayer) : AudioPlayer {
    override fun playAudio(audioType: String, fileName: String) {
        when (audioType.uppercase()) {
            "mp3" -> advancedAudioPlayer.playMp4(fileName)
            "wav" -> advancedAudioPlayer.playWav(fileName)
            else -> println("Unsupported audio format")
        }
    }
}

fun main() {
    val simpleAudioPlayer = SimpleAudioPlayer()
    val advancedAudioPlayer = AdvancedAudioPlayerImpl()
    val advancedAudioPlayerAdapter = AdvancedAudioPlayerAdapter(advancedAudioPlayer)

    simpleAudioPlayer.playAudio("mp3", "song.mp3")
    simpleAudioPlayer.playAudio("mp4", "video.mp4") // Unsupported audio format

    advancedAudioPlayerAdapter.playAudio("mp3", "song.mp3") // Uses playMp4 method of AdvancedAudioPlayer
    advancedAudioPlayerAdapter.playAudio("wav", "audio.wav") // Uses playWav method of AdvancedAudioPlayer
    advancedAudioPlayerAdapter.playAudio("ogg", "audio.ogg") // Unsupported audio format
}

/*

In this example, we used the Adapter Pattern to make the AdvancedAudioPlayer
work with the existing AudioPlayer interface. The AdvancedAudioPlayerAdapter
acts as a bridge between the two interfaces, allowing us to play mp3 and wav
files using the AdvancedAudioPlayer. This pattern enables us to seamlessly
integrate new functionality (i.e., new audio formats) into an existing application
without modifying its core components.

*/


