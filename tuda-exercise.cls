%- Identification -%

% Version
\def\fileversion{1.00}
\def\filedate{2021/08/17}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

% LateX 3 Syntax
\RequirePackage{expl3}

% Identification of the class
\ProvidesExplClass{tuda-exercise}
{\filedate}
{\fileversion}
{(TUDa-CI) - Exercise Template}

%- Preconfiguration -%
\LoadClass[
  color=3b,
  colorback=false,
  ngerman,
  solution=true
]{tudaexercise}

% Document color
\newcommand{\documentcolor}{\g_ptxcd_color_accent_tl}

%- Packages -%

%-- Box --%
\RequirePackage{tcolorbox}

%-- Caption --%
% Centering caption
\RequirePackage[justification=centering]{caption}

%-- Code --%
\RequirePackage{code-listings}

%-- Color --%
\RequirePackage{xcolor}

%-- Graphics--%
% Positioning
\RequirePackage{float}
% Relative graphic path
\RequirePackage{graphicx}
\RequirePackage{tikz}
\RequirePackage{star-rating}
\RequirePackage{fopbot}
\RequirePackage{memory-block}

%-- Import --%
% Import document content from another direcotry or different document.
\RequirePackage{import}
% Creating standalone documents to add them as sub document to the main document.
\RequirePackage{standalone}

%-- KOMA-Script --%
% Using Koma's float algorithm
\RequirePackage{scrhack}

%-- Language --%
\RequirePackage[english, main=ngerman]{babel}
% Quotes
\RequirePackage[babel]{csquotes}

%-- List --%
\RequirePackage{enumitem}

%-- Math --%
\RequirePackage{amsmath, amssymb}
% Lightning symbol
\RequirePackage{stmaryrd}
% Bold
\RequirePackage{bm}

%-- Table --%
% beautiful tables
\RequirePackage{booktabs}
% Coloring
\RequirePackage{colortbl}
% Combine rows
\RequirePackage{multirow}

%- Box -%

%-- Note boxes --%
% Custom skins
\tcbuselibrary{skins}

% Dictionary of default tuda colors
\prop_new:N \l__ptxcd_box_color_tuda_prop
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-gray} {TUDa-0c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-blue} {TUDa-2c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-dgreen} {TUDa-3b}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-lgreen} {TUDa-4c}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-orange} {TUDa-8b}
\prop_put:Nnn \l__ptxcd_box_color_tuda_prop {tuda-red} {TUDa-9b}

% Expand prop item
\cs_generate_variant:Nn \prop_item:Nn { Ne }

% Title of the box
\tl_new:N \l__ptxcd_box_title_tl
% Color of the box
\str_new:N \l__ptxcd_box_color_str

% Box options
% Do not make setting globally visible, only for one environment
\keys_define:nn {ptxcd/notebox}{
  title .code:n=\tl_set:Nn \l__ptxcd_box_title_tl {#1},
  title .default:n=,
  title .initial:n=,
  break .bool_set:N=\l__ptxcd_box_title_break_bool,
  break .default:n=true,
  break .initial:n=false,
  color .code:n=\str_set:Nx \l__ptxcd_box_color_str {#1},
  color .default:n=\g_ptxcd_color_accent_tl,
  color .initial:n=\g_ptxcd_color_accent_tl
}

% Note box environment
\NewDocumentEnvironment{note}{o}
{
%  Process options
  \IfNoValueF{#1}{\keys_set:nn {ptxcd/notebox}{#1}}
  % Retrieve color
  \str_set:Nx \l__ptxcd_box_color_apply_str {\str_use:N \l__ptxcd_box_color_str}
% Check if the color is a predefined tuda color and retrieve color value
  \prop_if_in:NVT \l__ptxcd_box_color_tuda_prop \l__ptxcd_box_color_apply_str
    {
    % Retrieve color valur from prop
    \str_set:Nx \l__ptxcd_box_color_apply_str {
      \prop_item:Ne \l__ptxcd_box_color_tuda_prop { \str_use:N \l__ptxcd_box_color_apply_str}
    }
  }

% Side note box
  \begin{tcolorbox}
    [
    arc=3pt, % Rounded borders
    boxrule=0pt,
    colback=\l__ptxcd_box_color_apply_str!5,
    enhanced, % Enable customization
    frame\space hidden,
    left=5pt, % Left side margin
    overlay={
      \begin{tcbclipinterior}
        \fill[\l__ptxcd_box_color_apply_str] (frame.south\space west) rectangle ([xshift=4pt]frame.north\space west);
      \end{tcbclipinterior}
    }
    ]
    % Print title if it is not empty
    \tl_if_empty:NF \l__ptxcd_box_title_tl {
      \textbf{\tl_use:N \l__ptxcd_box_title_tl}
      % Break line if option is on
      \bool_if:NT \l__ptxcd_box_title_break_bool{
        \\
      }
    }
      }
      {
  \end{tcolorbox}
}

%- Code -%

\let\code\texttt

%- Exercise -&

%-- Credit --%
% Credit position
\renewcommand*{\creditformat}[1]{\hfill #1}

%-- Subtask --%
% Counter
\renewcommand*{\thesubtask}{\arabic{subtask}}

% Format Taskname Tasknumber Subtasknumber Whitespace
\renewcommand*{\subtaskformat}{\taskname\thetask{}.\thesubtask\enskip}

%-- Task --%
% Counter
\renewcommand*{\thetask}{\arabic{task}}

% Language
\renewcaptionname{ngerman}{\taskname}{V}
\renewcaptionname{english}{\taskname}{V}

% Format Taskname Tasknumber
\renewcommand*{\taskformat}{\taskname\thetask{}}

% Seperator
\renewcommand*\sectionlinesformat[4]{%
  \parbox{\linewidth}{
    \bool_if:cT {g__ptxcd_ruled_#1_bool} {
      \rule[5\g_ptxcd_titlerule_dim]{\linewidth}{\g_ptxcd_titlerule_dim}\par\nointerlineskip
    }
    \@hangfrom{%
      \hskip #2#3}{
      \tl_if_eq:nnT {#1} {task} {
        \exp_args:No \tl_if_empty:nF {#4}
          {~} % Insert your task seperator here. Default ~: Whitespace
        \bool_if:NT \l__ptxcd_points_auto_bool {
          \exp_args:NNx \prop_get:NnN \g__ptxcd_loaded_points_prop {\thetask} \l_ptxcd_tmp_tl
          \quark_if_no_value:NF \l_ptxcd_tmp_tl {
            \fp_set:Nn \l_ptxcd_ex_task_points_fp {\l_ptxcd_tmp_tl}
          }
        }
      }
      #4
      \tl_if_in:nnT {#1} {task} {
        \tl_if_empty:cTF{l_ptxcd_ex_#1_credit_tl}
          {\pointformat{\fp_to_decimal:c {l_ptxcd_ex_#1_points_fp}}}
          {\creditformat{\tl_use:c {l_ptxcd_ex_#1_credit_tl}}}
      }
      \rule[-\dp\strutbox]{0pt}{\dp\strutbox}\par}\nointerlineskip
    \skip_vertical:n {\ptxcd_titlerule_sep: -\dp\strutbox}
    \bool_if:cT {g__ptxcd_ruled_#1_bool} {\smash{\rule{\linewidth}{\g_ptxcd_titlerule_dim}}}
  }}

%- Hyperref -%

\hypersetup{
  colorlinks=true,
  linkcolor=black,
  urlcolor=TUDa-2c,
}

%- Paragraph -%

% Indent
\setlength{\parindent}{0pt}
% Line break header and no indent
\cs_set_eq:NN \__ptxcd_paragraph:n \paragraph
\renewcommand{\paragraph}[1]{\__ptxcd_paragraph:n {#1}\hfill}

% Linke break
\newcommand{\br}{\vskip .5em}

%- Table of content -%

% Clear toc to next age
\newcommand{\cleartoc}{\addtocontents{toc}{\protect\clearpage}}

%- Tikz -%

%-- Libraries --%
\usetikzlibrary{positioning}

%- Title -%

%-- Author --%
\providecaptionname{ngerman, german}{\autorname}{
  \int_compare:nNnTF {\seq_count:N \l__ptxcd_author_seq} > {1}
    {Autoren}
    {Autor}
}
\providecaptionname{english, american, british}{\autorname}{
  \int_compare:nNnTF {\seq_count:N \l__ptxcd_author_seq} > {1}
    {Author}
    {Authors}
}

% Author sep for last author
\providecaptionname{ngerman, german}{\authorsep}{und}
\providecaptionname{english, american, british}{\authorsep}{and}

\seq_new:N \l__ptxcd_author_seq

% Push students to a sequence
\newcommand{\authors}[1]{
% Push author name to the right
  \seq_put_right:Nn \l__ptxcd_author_seq {#1}

% Prepare author convention
  \tl_set:Nx \c__ptxcd_namesr_tl {\seq_item:Nn \l__ptxcd_author_seq {1}}
% Comma separated authors
  \int_step_inline:nn {\seq_count:N \l__ptxcd_author_seq - 2}  {
    \tl_set:Nx \c__ptxcd_namesr_tl {
      \tl_use:N \c__ptxcd_namesr_tl, \space
      \seq_item:Nn \l__ptxcd_author_seq {\int_eval:n {##1 + 1}}
    }
  }
% Last author will be separated with "and"
  \int_compare:nNnTF {\seq_count:N \l__ptxcd_author_seq} > {1}
% If more than two author exists, add an "and, else do nothing
    {
    \tl_set:Nx \c__ptxcd_namesr_tl {
      \tl_use:N \c__ptxcd_namesr_tl\space
      \authorsep\space
      \seq_item:Nn \l__ptxcd_author_seq {\seq_count:N \l__ptxcd_author_seq}
    }
  }{}
% Set authors
  \author{\tl_use:N \c__ptxcd_namesr_tl}
}

%-- Version --%
\newcommand{\@version}{\today}
\newcommand{\version}[1]{\renewcommand{\@version}{#1}}
\providecaptionname{ngerman, german}{\versionname}{Version}
\providecaptionname{english, american, british}{\versionname}{Version}

%-- Department --%
\tl_new:N \l__ptxcd_department_tl
\newcommand{\department}[1]{\tl_gset:Nx \l__ptxcd_department_tl {#1}}
\providecaptionname{ngerman, german}{\departmentname}{Fachbereich}
\providecaptionname{english, american, british}{\departmentname}{Department}

%-- Semester --%
\tl_new:N \l__ptxcd_semester_str
\newcommand{\semester}[1]{\tl_gset:Nx \l__ptxcd_semester_tl {#1}}
\providecaptionname{ngerman, german}{\semestername}{Semester}
\providecaptionname{english, american, british}{\semestername}{Semester}

%-- Title style --%
\newcommand{\@titleformat}{
  \begin{minipage}[t]{.475\linewidth}
    % Author, department
    \xdef\@author {\@author}
    \ifx\@author\@empty
    \else
    \textbf{\autorname :}\space\usekomafont{author}\@author
    \fi
    \tl_if_empty:NF \l__ptxcd_department_tl
      {
      \\
      \usekomafont{author}\textbf{\departmentname :}\space\tl_use:N \l__ptxcd_department_tl
    }
    \tl_if_empty:NF \g_ptxcd_ex_sheetnum_tl
      {
      \\
      \ptxcd_nextsep\textbf{\sheetname}:\sheetsep\two@digits{\g_ptxcd_ex_sheetnum_tl}
    }
  \end{minipage}
  \hfill
  \begin{minipage}[t]{.475\linewidth}
    % Version, semester, sheet number
    \begin{flushright}
      \usekomafont{author}\textbf{\versionname :}\space\@version
      \tl_if_empty:NF \l__ptxcd_semester_tl
        {
        \\
        \tl_use:N \l__ptxcd_semester_tl
      }
    \end{flushright}
  \end{minipage}
}
\newcommand{\titleformat}[1]{\renewcommand{\@titleformat}{#1}}

%-- Title format --%
\renewcommand*{\@maketitle}{%
  \global\@topnum=\z@
  \setparsizes{\z@}{\z@}{\z@\@plus 1fil}\par@updaterelative
  \vspace*{-\dim_eval:n {
    \headheight
    -\c_ptxcd_largerule_dim -\c_ptxcd_rulesep_dim
    +\headsep
    +\ht\strutbox
    +\p@
  }}
  \par
  \nointerlineskip
  \begingroup
  \setlength{\fboxsep}{\z@}
  \bool_if:NT \g_ptxcd_colorback_bool {\colorbox{accentcolor}}{\parbox[t]{\linewidth}{
    \rule{0pt}{\bool_if:NTF \g_ptxcd_smalltitle_bool {.25} {.5}\c_ptxcd_logoheight_dim}
    \par\nointerlineskip
    \raisebox{-\height}{%
      \begin{minipage}[t]{\dimexpr\linewidth-2.2\c_ptxcd_logoheight_dim-1ex}
        \bool_if:NT \g_ptxcd_colorback_bool  {\begin{addmargin}{3mm}}
        \raggedright
        \bool_if:NT \g_ptxcd_colorback_bool {\color{textonaccentcolor}}
        \tl_if_empty:NF \@titlehead {\usekomafont{titlehead}{\@titlehead\par}}
        \leavevmode\usekomafont{title}%
        {\usekomafont{title}\bool_if:NTF \g_ptxcd_smalltitle_bool {\LARGE} {\huge} {\@title\par}}%
        \vskip 1em
        \bool_if:NF \g_ptxcd_ex_compatibility_bool
          {
            {\ifx\@subtitle\@empty\else\usekomafont{subtitle}\@subtitle\par\fi}%
          \gdef\@subtitle{}
          \vskip .5em
        }
          {}
        \vskip .5em
        \bool_if:NTF \g_ptxcd_colorback_bool {
      \end{addmargin}} {\par}
\end{minipage}}
\tl_if_empty:NF \g_ptxcd_logofile_tl {
\hfill\raisebox{\dim_eval:n {
\bool_if:NTF \g_ptxcd_colorback_bool
{-\height}
{-.9\c_ptxcd_logoheight_dim}
}}
[0pt]
[\dim_eval:n {
\bool_if:NTF \g_ptxcd_smalltitle_bool
{\bool_if:NTF \g_ptxcd_colorback_bool {1.15}{1}}
{\bool_if:NTF \g_ptxcd_colorback_bool {1.5}{1.3}
}\c_ptxcd_logoheight_dim}]
{\makebox[2.2\c_ptxcd_logoheight_dim][l]{\includegraphics[height=\c_ptxcd_logoheight_dim]{\g_ptxcd_logofile_tl}}}
}
\par\medskip
}}
\par
\nointerlineskip
\rule{\linewidth}{\g_ptxcd_titlerule_dim}
% subtitle fields if not compat
\exp_args:Nf \tl_if_empty:nF {\g_ptxcd_ex_sheetnum_tl\use:c {@subsubtitle}\@subtitle}{
\par\nointerlineskip
\bool_if:NT \g_ptxcd_colorback_bool {\colorbox{accentcolor}}{
\parbox{\linewidth}{
\begin{minipage}{\linewidth}
\bool_if:NT \g_ptxcd_colorback_bool {
\color{textonaccentcolor}
\begin{addmargin}{3mm}
}
\null\par
\def\ptxcd_nextsep{}
\clist_map_inline:nn {@subtitle, @subsubtitle} {
\tl_if_empty:cF {##1} {\ptxcd_nextsep\use:c {##1}\def\ptxcd_nextsep{\\}}
}
\@titleformat
\bool_if:NT \g_ptxcd_colorback_bool {\end{addmargin}}
\end{minipage}
\vspace*{\dp\strutbox}
}}\par\nointerlineskip
\rule{\linewidth}{\g_ptxcd_titlerule_dim}
}
\par
\bool_if:NT  \g_ptxcd_headontitle_bool {
\if@twoside
\box_use:N \g_ptxcd_ex_headline_odd_box
\else
\box_use:N \g_ptxcd_ex_headline_oneside_box
\fi
\par
\rule{\linewidth}{\g_ptxcd_titlerule_dim}
\par
}
\endgroup
\vskip 2em
\ConfigureHeadline{}
}%

%- Solution mode -%

\newcommand{\clearpagesolution}{
\bool_if:NT \l_ptxcd_ex_solution_bool{\clearpage}
}

\newcommand{\clearpagenosolution}{
\bool_if:NF \l_ptxcd_ex_solution_bool{\clearpage}
}

%- Additional configurations -%

% Title information
\title{Check~und~Prepare}

\authors{Nhan~Huynh}
\authors{Darya~Nikitina}
\department{Informatik}
\semester{Semesterübergreifend}

% Solution mode
\bool_if:NTF \l_ptxcd_ex_solution_bool{
\subtitle{Lösungsvorschläge}
\makeatletter
\ConfigureHeadline{headline={\sheetname\sheetsep\two@digits{\g_ptxcd_ex_sheetnum_tl} :~Lösungsvorschläge~von~\@author}}
\makeatother
}
{
\subtitle{Vorbereitende~Übungen}
\makeatletter
\ConfigureHeadline{headline={\sheetname\sheetsep\two@digits{\g_ptxcd_ex_sheetnum_tl} :~Vorbereitende~Übungen~von~\@author}}
\makeatother
}


