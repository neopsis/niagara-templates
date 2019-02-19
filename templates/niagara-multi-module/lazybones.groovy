@Grab(group="uk.co.cacoethes", module="groovy-handlebars-engine", version="0.2")
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine

registerDefaultEngine new HandlebarsTemplateEngine()

def params = [:]

params.moduleName    = ask("Module name [niagara]: ", "niagara", "moduleName")
params.moduleVersion = ask("Module Version [4.0.0]: ", "4.0.0", "moduleVersion")
params.moduleGroup   = ask("Vendor [Neopsis]: ", "Neopsis", "moduleGroup")
params.preferredSymbol = ask("Preferred symbol [neo] : ", "neo", "preferredSymbol")

processTemplates 'vendor.gradle', params
processTemplates 'settings.gradle', params
processTemplates "rt/rt.gradle", params
processTemplates "ux/ux.gradle", params
processTemplates "wb/wb.gradle", params

File rtDir = new File(projectDir, 'rt')
File uxDir = new File(projectDir, 'ux')
File wbDir = new File(projectDir, 'wb')
File rtBuild = new File(projectDir, 'rt/rt.gradle')
File uxBuild = new File(projectDir, 'ux/ux.gradle')
File wbBuild = new File(projectDir, 'wb/wb.gradle')

rtBuild.renameTo(projectDir.name + "/rt/" + params.moduleName + "-rt.gradle")
uxBuild.renameTo(projectDir.name + "/ux/" + params.moduleName + "-ux.gradle")
wbBuild.renameTo(projectDir.name + "/wb/" + params.moduleName + "-wb.gradle")

rtDir.renameTo(projectDir.name + "/" + params.moduleName + "-rt");
uxDir.renameTo(projectDir.name + "/" + params.moduleName + "-ux");
wbDir.renameTo(projectDir.name + "/" + params.moduleName + "-wb");
