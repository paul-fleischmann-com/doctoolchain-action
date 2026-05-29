inputPath = 'docs'

outputPath = System.getenv('DTC_OUTPUT_PATH') ?: 'build/docs'

inputFiles = [
  [file: 'index.adoc', formats: ['html']],
  [file: 'master-pdf.adoc', formats: ['pdf']],
]

asciidoc = [
  attributes: [
    'outfilesuffix': '.html',
    'toc': 'left',
    'sectlinks': true
  ]
]