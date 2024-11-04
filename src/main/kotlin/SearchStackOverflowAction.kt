import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.SelectionModel

class SearchStackOverflowAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val editor: Editor? = event.getData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR)

        if (editor != null) {
            val selectionModel: SelectionModel = editor.selectionModel
            val selectedText = selectionModel.selectedText

            if (!selectedText.isNullOrEmpty()) {
                BrowserUtil.browse("https://stackoverflow.com/search?q=" + selectedText)
            }
            else{
                BrowserUtil.browse("https://stackoverflow.com")
            }
        }
    }

}