/*
function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 10,
        center: { lat: 55.751244, lng: 37.618423 } // Координаты центра карты (Москва)
    });

    // Пример объектов
    var objects = [
        {
            position: { lat: 55.751244, lng: 37.618423 },
            title: 'Объект 1',
            id: 1 // ID объекта для перехода на страницу деталей
        },
        {
            position: { lat: 55.761244, lng: 37.628423 },
            title: 'Объект 2',
            id: 2 // ID объекта для перехода на страницу деталей
        }
        // Другие объекты...
    ];

    objects.forEach(function (obj) {
        var marker = new google.maps.Marker({
            position: obj.position,
            map: map,
            title: obj.title,
            icon: '/static/images/custom-icon.png' // Кастомная иконка для метки
        });

        marker.addListener('click', function () {
            openCarousel(obj.id); // Открываем карусель при клике
        });
    });
}

function openCarousel(objectId) {
    // Обновляем ссылки в карусели, основываясь на ID объекта
    var baseURL = '/object-details'; // Базовый URL для страниц деталей объектов
    document.querySelectorAll('.swiper-slide a').forEach(function(link) {
        link.href = baseURL + '?id=' + objectId; // Добавляем ID объекта к ссылке
    });

    // Отображаем карусель
    document.getElementById('carousel').style.display = 'block';
}

function closeCarousel() {
    // Скрываем карусель
    document.getElementById('carousel').style.display = 'none';
}
*/
