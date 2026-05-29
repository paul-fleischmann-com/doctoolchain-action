inputPath = 'docs'

outputPath = System.getenv('DTC_OUTPUT_PATH') ?: 'build/docs'

inputFiles = [
  [file: 'user-guide/index.adoc', formats: ['html', 'pdf']],
]

asciidoc = [
  attributes: [
    'outfilesuffix': '.html',
    'toc': 'left',
    'sectlinks': true
  ]
]