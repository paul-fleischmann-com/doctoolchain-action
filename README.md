# doctoolchain-action

GitHub Composite Action to build AsciiDoc documentation using [docToolchain](https://doctoolchain.org) via Docker. No local Java or Gradle installation required.

## Usage

```yaml
- uses: paul-fleischmann-com/doctoolchain-action@v1
  with:
    output-path: build/docs       # DTC_OUTPUT_PATH (default: build/docs)
    tasks: generateHTML generatePDF  # space-separated tasks (default: generateHTML)
    config-file: docToolchainConfig.groovy  # default
```

The action automatically downloads `dtcw` if it is not already present in the repository.

## Inputs

| Input | Description | Default |
|---|---|---|
| `output-path` | Output directory (`DTC_OUTPUT_PATH`) | `build/docs` |
| `tasks` | Space-separated docToolchain tasks | `generateHTML` |
| `config-file` | Path to `docToolchainConfig.groovy` | `docToolchainConfig.groovy` |
| `dtcw-path` | Path to dtcw wrapper | `./dtcw` |

## Requirements

- Docker must be available on the runner (`ubuntu-latest` works out of the box)
- A `docToolchainConfig.groovy` must exist in the repository root (or at `config-file` path)

## Example: GitHub Pages deployment

```yaml
- uses: actions/checkout@v4
- uses: paul-fleischmann-com/doctoolchain-action@v1
  with:
    output-path: build/docs
    tasks: generateHTML
- uses: actions/upload-pages-artifact@v3
  with:
    path: build/docs/html5
```

## Example: Release assets (GoReleaser)

In `.goreleaser.yaml`:
```yaml
before:
  hooks:
    - go mod tidy
    - bash -c "DTC_OUTPUT_PATH=dist/docs ./dtcw docker generateHTML generatePDF"

extra_files:
  - glob: dist/docs/html5/**/*
  - glob: dist/docs/pdf/*.pdf
```
