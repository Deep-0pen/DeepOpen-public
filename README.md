<p align="center">
  <img src="/extras/DeepOpen.png" />
</p>

Attempt to recreate code of Fishlabs games and their common core Abyss Engine for education and enternainment purposes, by revese engineering.

Currently the essence of this repo is the [name mapping for GoF2](Recaf/GoF2/GoF2_JSR_1.0.4.mapping) version 1.0.4 (the last update for J2ME published for free by the fishes)
___
<p align="center">
  <img src="/extras/logger/progress_chart.png" />
</p>

___
### Goals
1. Getting fully readable code java code
    * Deobufuscating GoF2 classes, fields and methods names using Recaf - now
    * Deobufuscating insides of methods - touched (.aem loading class implemented in [GoF2:Reforged](https://drive.google.com/drive/folders/198TUt7ERvaK7kdShcHvn_otm48rbBnKV)$^1$)
    * Making documentation of the code.
2. Porting to other platforms, modding java...
___

### Want to contribute?

Software requirements:\
Linux, Windows or [an other one]\
**[Recaf 4](https://github.com/Col-E/Recaf-Launcher/blob/master/MANUAL.md)**: Java 22+ 64-bit\
Testing and dynamic analysis (emulator):\
**KEmulator** ([nnmod](https://nnp.nnchan.ru/kem/) - has multiplatform version)

Deobfuscation procedure (what I do):

1. In Recaf to get get deobfuscated .jar (that's what I do):
      - *File* -> *Open workspace* -> load /Recaf/GoF2/[GoF2_JSR_1.0.4.jar](/Recaf/GoF2/GoF2_JSR_1.0.4.jar) (or drag and drop the file on Recaf = *load*)
      - *Mapping* -> *Apply* -> *Simple* -> load /Recaf/GoF2/[GoF2_JSR_1.0.4.mapping](/Recaf/GoF2/GoF2_JSR_1.0.4.mapping) 
      - (optional) do the *renaming: *contex menu* or *Alt+R* 
      - *File* -> *Export application* -> save as a .jar file (I name it *GoF2_deobfuscation.jar*)
2. If you want to share your progress outside Github:
      - *load* the deobfuscated .jar from step 1.
      - do the *renaming: *contex menu* or *Alt+R* 
      - *File* -> *Export application* -> save as a .jar file
3. In KEmulator:
    - Test $^2$ by running the .jar
    - Dynamic analysis:  tab *View*-> Watches/Methods/Memory View/Log/Options...*
4. In Recaf:
    - If testing went well: *Mapping* -> *Export* -> *Simple*

$^2$ If you screwed up or Recaf brakes (happens), but have unsaved renaming, save the mapping without overwritting the old one. Try reloading .jar and mapping or try fixing the new mapping in text editor.\
$^1$ Biggest GoF2 Mod as of now (2024-10-20). Source code I haven't seen, haven't accessed and will not be published.

More: \
[Pre Recaf attempts](/src/README.md)\
[Renaming inspiration](/extras/gof2-1.0.1-ios-symbols/simple-mapping)\
[Lookup tables for GoF2](https://docs.google.com/spreadsheets/u/1/d/e/2PACX-1vRjJFtnrG9-7vdqHtHtPCu0Tg7C-1A89lxo434_7fgEguS9I6O1u3wcRmoWnHEhgUP2Mbd9EMIzAPJA/pubhtml#)  (work in progress)
