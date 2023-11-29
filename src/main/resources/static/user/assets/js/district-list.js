const $regionCode = document.querySelector('#regionCode');
const $districtCode = document.querySelector('#districtCode');

// Ajax를 호출할 URL과 Query 스트링
let districtListUrl = '/user/register/districtList?regionCode=';

$regionCode.addEventListener('change', function () {
    if($districtCode.childElementCount >= 2) {
        $districtCode.replaceChildren();
    }
    const regionValue = $regionCode.value;
    const requestDistrictList = districtListUrl + regionValue;
    getDistrictList(requestDistrictList);
})

function getDistrictList(districtListUrl) {
    fetch(districtListUrl)
        .then(response => response.json())
        .then(json => json.forEach((data) => {
            let districtOption = document.createElement("option");
            districtOption.value = `${data.districtCode}`;
            districtOption.text = `${data.districtName}`;
            $districtCode.appendChild(districtOption);
        }))
}