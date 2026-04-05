const intervalId = setInterval(function() {setCodeCookie(getCode());}, 30 * 1000) // saves the code every 30 seconds
let current_file = ""
const files = new Map()
addFile();

function getCodeFromCookie() {
    document.getElementById("code").value = getCookie("code");
}

function getCode() {
    return document.getElementById("code").value;
}

function setCodeCookie(code) {
    document.cookie = `code=${code}`;
}

function getCookie(name) {
    const match = document.cookie.match(new RegExp('(^|;\\s*)' + name + '=([&;]*)'));
    return match ? decodeURIComponent(match[2]) : null;
}


function addFile() {
    const filename = `file${files.size + 1}`;
    files.set(filename, "");
    const btn = document.createElement("button");
    btn.textContent = filename;
    document.getElementById("file-switcher").appendChild(btn)
    btn.onclick = () => {
        if (current_file !== "") {
            files.set(current_file, document.getElementById("code").value);
        }
        document.getElementById("code").value = files.get(filename);
        current_file = filename
    }
}