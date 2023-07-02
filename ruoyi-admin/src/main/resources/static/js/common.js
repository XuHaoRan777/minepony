// 测试
let baseUrl = 'http://127.0.0.1:8077';
// 正式
// let baseUrl = 'http127.0.0.1:8077';

// 各种状态码
let success_code = 2001;
let warning_code = 4001;
let error_code = 5005;
let bad_code = 500;


// 创建axios的一个实例
const instance = axios.create({
    baseURL: baseUrl, // 设置默认基本URL
    timeout: 10000, // 设置请求超时时间（5秒）
    headers: { 'Content-Type': 'application/json' } // 设置默认请求头
});


// 消息提示
// type - 1:成功，2:信息，3:警告，3:警告，4:错误，5:首选，6:次要的，7:深灰色，8:浅灰色
function showAlert(message, type) {
    let type_class = 'alert-';
    switch (type){
        case 1: type_class += 'success'; break;
        case 2: type_class += 'info'; break;
        case 3: type_class += 'warning'; break;
        case 4: type_class += 'danger'; break;
        case 5: type_class += 'primary'; break;
        case 6: type_class += 'secondary'; break;
        case 7: type_class += 'dark'; break;
        case 8: type_class += 'light'; break;
        default: type_class += 'primary';
    }
    // 创建样式元素
    const style = document.createElement('style');
    style.innerHTML = `
        .alert {
            opacity: 0;
            transition: opacity 0.5s, transform 0.5s;
            transform: translateY(-100%);
            position: fixed;
            top: 20px;
            right: 20px;
            z-index: 10000;
        }

        .alert.show {
            opacity: 1;
            transform: translateY(0);
        }
    `;
    document.head.appendChild(style);

    // 创建alert元素
    const alertDiv = document.createElement("div");
    alertDiv.classList.add("alert", type_class, "alert-dismissible");

    // 创建关闭按钮
    // const closeButton = document.createElement("button");
    // closeButton.type = "button";
    // closeButton.classList.add("close");
    // closeButton.innerHTML = "&times;";
    // closeButton.onclick = function () {
    //     alertDiv.classList.remove('show');
    //     setTimeout(() => {
    //         document.body.removeChild(alertDiv);
    //         document.head.removeChild(style); // remove the style element as well
    //     }, 500); // 500ms 是动画持续时间，需要和 CSS 文件里的一致
    // };

    // 创建文本信息
    const strong = document.createElement("strong");
    strong.innerText = "信息: ";

    const textNode = document.createTextNode(` ${message}`);

    // 添加内容到alert元素
    // alertDiv.appendChild(closeButton);
    alertDiv.appendChild(strong);
    alertDiv.appendChild(textNode);

    // 添加alert元素到页面
    document.body.appendChild(alertDiv);

    // 添加显示类以开始动画
    setTimeout(() => {
        alertDiv.classList.add('show');
    }, 10);

    // 自动关闭alert
    setTimeout(() => {
        alertDiv.classList.remove('show');
        setTimeout(() => {
            document.body.removeChild(alertDiv);
            document.head.removeChild(style); // remove the style element as well
        }, 500); // 和动画持续时间一致
    }, 2500);
}