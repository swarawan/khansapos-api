package com.swarawan.khansapos.ext

import org.springframework.util.ResourceUtils
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Files

fun File.readFile(): String = String(Files.readAllBytes(this.toPath()))