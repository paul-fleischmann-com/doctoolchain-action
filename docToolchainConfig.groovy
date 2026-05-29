outputPath = System.getenv('DTC_OUTPUT_PATH') ?: 'build/docs'

inputPath = 'docs'

inputFiles = [
    [file: 'user-guide/index.adoc', formats: ['html', 'pdf']],
]

imageDirs = ["${inputPath}/images"]