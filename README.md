## Lazybones templates for Niagara

Simple templates for Niagara projects created with the
[Lazybones Project Creation Tool](https://github.com/pledbrook/lazybones). Lazybones allow you
to create a new project structure for Nigaray framework from a template, as a replacement for
the Workbench menu `Tools -> New Module`. The concept of Lazybones is very similar to Maven 
archetypes, and what Yeoman does for web applications. For more details please visit the
[Laybones
GitHub project](https://github.com/pledbrook/lazybones).

Neopsis provides two templates:

* Generic project with RT, UX and WB subprojects
* Minimal Neopsis Envas project. 

### How to use the templates

1. Grab the Laybones binary distribution [from Bintray](https://bintray.com/pkg/show/general/pledbrook/lazybones-templates/lazybones),
   unpack it to a local directory, and then add its 'bin' directory to your PATH environment 
   variable. 
   
2. In your Windows home directory create the file `~/.lazybones/config.groovy` with the following content
   (current templates are based on Niagara 4.6 and work fine for 4.7 projects. We will publish new structures when 
   they will be released)

   ```
   templates {
       mappings {
           niagara = "https://github.com/neopsis/lazybones/releases/download/4.6/niagara-multi-module-template.zip"
           envas   = "https://github.com/neopsis/lazybones/releases/download/4.6/niagara-envas-module-template.zip"
       }
   }
   ```
   
3. Open your command prompt in the directory, where you are going to create your Niagara module. The following 
   command will list all available templates including your Niagara templates:

   ```
   lazybones list
   ``` 
   
   To create an empty Niagara module project use the command 
   
   ```
   create <template> <dir>
   ```
     
   where  
   * template - The name of the project template to use.
   * dir      - The name of the directory in which to create the project structure. 
                This can be '.' to mean `in the current directory`.
                
   and answer the questions on the command line. Example create module `test` in the 
   current directory:
   
   ```
    lazybones create niagara .
   ```
   
4. Open your new module project with your favourite IDE, review and update your gradle make files. Especially
   you need to update the niagara version in the file `environment-gradle`, the code signing certificate alias 
   in the file `build.gradle` and all module specific dependencies in the module specific build files.     
      
   
   