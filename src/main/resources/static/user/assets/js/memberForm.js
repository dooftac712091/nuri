const submitBtn = document.querySelector("#submit-btn");

let memberInfo = {
    method : 'POST',
    headers : {
        "Content-Type" : "application/json; charset=UTF-8",
    },
    body : JSON.stringify({
        "userId" : $userId.value,
        "userPw" : $userPw.value,
        "userName" : $userName.value,
        "userBirth" : $userBirth.value,
        "userContact" : $userContact.value,
        "userEmail" : $userEmail.value,
        "regionCode" : $regionCode.value,
        "districtCode" : $districtCode.value,
        "userAddress" : $address1.value,
    })
}

function sendMemberInfo () {
    fetch("/user/register/memberRegister", memberInfo)
}

function sendMemberCardInfo () {
    fetch("/user/mun")
}

submitBtn.addEventListener('click', () => {
    sendMemberInfo();
})