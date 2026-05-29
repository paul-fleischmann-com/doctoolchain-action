inputPath = 'docs'

outputPath = System.getenv('DTC_OUTPUT_PATH') ?: 'build/docs'

inputFiles = [
  [file: 'user-guide/index.adoc', formats: ['html']],
  [file: 'user-guide/master-pdf.adoc', formats: ['pdf']],
]

asciidoc = [
  attributes: [
    'outfilesuffix': '.html',
    'toc': 'left',
    'sectlinks': true
  ]
]