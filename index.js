<SCRIPT>
function ShowFolderList(folderspec)
{
var fso, f, fc, s;
fso = new ActiveXObject("Scripting.FileSystemObject");
f = fso.GetFolder(folderspec);
fc = new Enumerator(f.Files);
s = "";
for (; !fc.atEnd(); fc.moveNext())
{
s += fc.item();
s += "<br/>";
}

document.write(s);
}
</SCRIPT>