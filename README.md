# CsvToChtParser

Program to convert CSV file to CHT file.

### Requirements

- JRE 8

### Usage

Go to [releases page](https://github.com/AdrianoSiqueira/CsvToChtParser/releases/latest) and download the jar package. Then run as follows:

```shell
java -jar CsvToChtParser.jar [target] [input_file] [output_file]
```

**Where**

```
[target]
    --duckstation
        The output file will conform with the DuckStation standards.
    --pcsxr
        The output file will conform with the PCSXR standards.

[input_file]
    Path to CSV file.
    
[output_file]
    Path to CHT file. It will be created if does not exists.
```
