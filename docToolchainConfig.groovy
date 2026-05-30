inputPath = 'docs'

outputPath = System.getenv('DTC_OUTPUT_PATH') ?: 'build/docs'

inputFiles = [
  [file: 'user-guide/pdf.adoc', formats: ['pdf']],
  [file: 'user-guide/index.adoc', formats: ['html']],
]

asciidoc = [
  attributes: [
    'outfilesuffix': '.html',
    'toc': 'left',
    'sectlinks': true,
    'doctype': 'book'
  ]
]