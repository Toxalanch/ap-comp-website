const intervalId = setInterval(function() {setCodeCookie(getCode());}, 30 * 1000) // saves the code every 30 seconds

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