# Check + Prepare Computer Science

- Open to students of all years 
- https://moodle.informatik.tu-darmstadt.de/course/view.php?id=1028
- Includes all preparatory exercises from the Check + Prepare course.
- Primary language: German

## Installation

### Compile LaTeX

The custom packages must exist on the TeX path so that the packages can be used.

This can be found with the command:

```sh
kpsewhich -var-value=TEXMFHOME
```

> Under Linux this is usually `~/texmf/tex/latex`

## Usage

The compiled TeX sources can be found in `build/`. You can also compile all LaTeX sources using the
shell script:
- `sh compile.sh`: Compiles missing PDFs in `build/` or changed TeX sources.

Optional arguments:
- `-all`: Compiles all TeX source files
- `[0-9]+`: A number which specifies how often the TeX source should be compiled. Default number
  is 2.

Note that a TeX distribution and the package `tuda-ci` must be available.
