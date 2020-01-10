## Lazybones templates for Niagara

Simple templates for Niagara projects created with the
[Lazybones Project Creation Tool](https://github.com/pledbrook/lazybones). Lazybones allow you
to create a new project structure for Nigaray framework from a template, as a replacement for
the Workbench menu `Tools -> New Module`. The concept of Lazybones is very similar to Maven 
archetypes, and what Yeoman does for web applications. For more details please visit the
[Laybones GitHub project](https://github.com/pledbrook/lazybones).

Neopsis provides two templates:

* Generic project with -rt, -ux and -wb subprojects
* Minimal Neopsis Envas project. 

### How to use the templates

1. Grab the Laybones binary distribution [from Bintray](https://bintray.com/pkg/show/general/pledbrook/lazybones-templates/lazybones),
   unpack it to a local directory, and then add its 'bin' directory to your PATH environment variable. 
   
2. In your Windows home directory `%HOMEDRIVE%%HOMEPATH%` (example C:\Users\john) create
 
    * directory `.lazybones`
    * file `.lazybones\config.groovy` 
    
    and add the foolowing content into the file `config.groovy`
 
    ```
    templates {
       mappings {
           niagara = "https://github.com/neopsis/niagara-templates/releases/latest/download/niagara-multi-module-template.zip"
           envas   = "https://github.com/neopsis/niagara-templates/releases/latest/download/niagara-envas-module-template.zip"
       }
    }
    ```
   
   > **Note**: how to create a Windows folder with name starting with a dot? Create a New Folder from Windows Explorer as you normally would.
           When prompted to enter a name, type: `.lazybones.` (**notice the dot at the end**) and press Enter. 
   
3. Open your command prompt in the directory, where you are going to create your Niagara module. The following 
   command will list all available templates including your Niagara templates:

   ```
   lazybones list
   ``` 
   
   To create an empty Niagara module project use the following command and answer all questions on the command line.  
   
   ```
   create <template> <dir>
   ```
     
   where  
   * template - The name of the project template to use.
   * dir      - The name of the directory in which to create the project structure. 
                It can be `.` to mean `in the current directory`.
                
   Examples:
    
   Create a new Niagara project in the current directory:
   
   ```
    lazybones create niagara .
   ```
   
   Create a new Envas project in the subdirectory `envasDemo`:
   
   ```
    lazybones create envas envasDemo
   ```
   
4. Open your new module project with your favourite IDE as a Gradle project and review all Gradle files. 
   Mainly you need to review the Niagara version in the file `environment.gradle`, the code signing 
   certificate alias in the file `build.gradle` and dependencies in the module-specific Gradle build files. 
    
      
   
   
