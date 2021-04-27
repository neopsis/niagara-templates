@Grab(group="uk.co.cacoethes", module="groovy-handlebars-engine", version="0.2")
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine
import org.apache.commons.io.FileUtils
import uk.co.cacoethes.util.NameType

registerDefaultEngine new HandlebarsTemplateEngine()

def params = [:]

if (projectDir.name =~ /\-/) {
    params.projectClassName = transformText(projectDir.name, from: NameType.HYPHENATED, to: NameType.PROPERTY)
} else {
    params.projectClassName = transformText(projectDir.name, from: NameType.PROPERTY, to: NameType.CAMEL_CASE)
}

params.projectName = transformText(params.projectClassName, from: NameType.CAMEL_CASE, to: NameType.PROPERTY)

params.moduleName         = ask("Module name [" + params.projectName + "]: ", params.projectName, "moduleName")
params.moduleDescription  = ask("Module description [Niagara demo module]: ", "Niagara demo module", "moduleDescription")
params.moduleGroup        = ask("Vendor [Neopsis]: ", "Neopsis", "moduleGroup")
params.moduleVersion      = ask("Module Version [4.7.0]: ", "4.7.0", "moduleVersion")
params.preferredSymbol    = ask("Preferred symbol [neo] : ", "neo", "preferredSymbol")
params.pkg                = ask("Package [com.example] : ", "com.example", "package")

String packagePath        = params.pkg.replace('.' as char, '/' as char)
File mainSourcesRoot      = new File(projectDir, 'wb/src/main/java')
File mainSourcesPath      = new File(mainSourcesRoot, packagePath)

File rtDir = new File(projectDir, 'rt')
File uxDir = new File(projectDir, 'ux')
File wbDir = new File(projectDir, 'wb')
File rtBuild = new File(projectDir, 'rt/rt.gradle')
File uxBuild = new File(projectDir, 'ux/ux.gradle')
File wbBuild = new File(projectDir, 'wb/wb.gradle')

processTemplates 'vendor.gradle', params
processTemplates 'settings.gradle', params
processTemplates "rt/rt.gradle", params
processTemplates "ux/ux.gradle", params
processTemplates "wb/wb.gradle", params

def renameFile = { File from, String path ->
    if (from.file) {
        File to = new File(path)
        to.parentFile.mkdirs()
        FileUtils.moveFile(from, to)
    }
}

mainSourcesRoot.eachFile { File file ->
    renameFile(file, mainSourcesPath.absolutePath + '/' + file.name)
}

rtBuild.renameTo(projectDir.name + "/rt/" + params.moduleName + "-rt.gradle")
uxBuild.renameTo(projectDir.name + "/ux/" + params.moduleName + "-ux.gradle")
wbBuild.renameTo(projectDir.name + "/wb/" + params.moduleName + "-wb.gradle")

rtDir.renameTo(projectDir.name + "/" + params.moduleName + "-rt");
uxDir.renameTo(projectDir.name + "/" + params.moduleName + "-ux");
wbDir.renameTo(projectDir.name + "/" + params.moduleName + "-wb");
