let motsCaches = document.querySelector('span');

motsCaches.addEventListener('click', function (event) {
    console.log('cache');

    if (motsCaches.style.opacity == 0) {
        motsCaches.style.opacity = 100;
    } else {
        motsCaches.style.opacity = 0;
    }


})

let btn = document.querySelector('button');

let div = document.querySelector('div');

let cache = document.getElementById('cache');
cache.style.display = "none";

btn.addEventListener('click', function (event) {
    console.log('btnCache');
    console.log(cache)

    if (cache.style.display == "none") {
        cache.style.display = "block";
        console.log(cache);

    } else {
        cache.style.display = "none";
        console.log("ajoute");

    }


})