$.get("../../pets.xml", function (xml, status) {
  $(xml)
    .find("pets")
    .each(function () {
      const name = $(this).find("name").text();
      const species = $(this).find("species").text();
      const color = $(this).find("color").text();
      const age = $(this).find("age").text();
      const gender = $(this).find("gender").text();
      const price = $(this).find("price").text();
      const comment = $(this).find("comment").text();
      var imageSrc = "";
      var breed = "";
      var breeder = "";
      var preferredFood = "";
      var isPredator = "";
      var isFreshWater = "";
      var isAggressive = "";
      
      var cardHtml = ``

      switch (species) {
        case "Dog":
          imageSrc = "images/dog12.jpg";
          breed = $(this).find("breed").text();
          breeder = $(this).find("breeder").text();
          cardHtml =
          `
            <div class="col">
              <div class="card card-margin">
                <img
                class="card-img-top"
                src="${imageSrc}"
                alt="Card image"
                />
                <div class="card-body">
                  <p class="card-text">Name: ${name}</p>
                  <p class="card-text">Species: ${species}</p>
                  <p class="card-text">Breed: ${breed}</p>
                  <p class="card-text">Breeder: ${breeder}</p>
                  <p class="card-text">Color: ${color}</p>
                  <p class="card-text">Age: ${age} years</p>
                  <p class="card-text">Gender: ${gender}</p>
                  <p class="card-text">Price: ${price} $</p>
                  <p class="card-text">Comment: ${comment}</p>
                </div>
              </div>
            </div>
            `
          break;
        case "Rodent":
          imageSrc = "images/Hamster.jpg";
          isAggressive = $(this).find("isAggressive").text();//Hidden
          cardHtml = 
          `
            <div class="col">
              <div class="card card-margin">
                <img
                class="card-img-top"
                src="${imageSrc}"
                alt="Card image"
                />
                <div class="card-body">
                  <p class="card-text">Name: ${name}</p>
                  <p class="card-text">Species: ${species}</p>
                  <p class="card-text">Color: ${color}</p>
                  <p class="card-text">Age: ${age} years</p>
                  <p class="card-text">Gender: ${gender}</p>
                  <p class="card-text">Price: ${price} $</p>
                  <p class="card-text">Comment: ${comment}</p>
                </div>
              </div>
            </div>
            `
          break;
        case "Cat":
          imageSrc = "images/cat1.jpg";
          breed = $(this).find("breed").text();
          breeder = $(this).find("breeder").text();
          cardHtml =
          `
          <div class="col">
            <div class="card card-margin">
              <img
              class="card-img-top"
              src="${imageSrc}"
              alt="Card image"
              />
              <div class="card-body">
                <p class="card-text">Name: ${name}</p>
                <p class="card-text">Species: ${species}</p>
                <p class="card-text">Breed: ${breed}</p>
                <p class="card-text">Breeder: ${breeder}</p>
                <p class="card-text">Color: ${color}</p>
                <p class="card-text">Age: ${age} years</p>
                <p class="card-text">Gender: ${gender}</p>
                <p class="card-text">Price: ${price} $</p>
                <p class="card-text">Comment: ${comment}</p>
              </div>
            </div>
          </div>
          `
          break;
        case "Bird":
          imageSrc = "images/bird12.jpg";
          preferredFood = $(this).find("preferredFood").text();
          cardHtml =
          `
          <div class="col">
            <div class="card card-margin">
              <img
              class="card-img-top"
              src="${imageSrc}"
              alt="Card image"
              />
              <div class="card-body">
                <p class="card-text">Name: ${name}</p>
                <p class="card-text">Species: ${species}</p>
                <p class="card-text">Preferred Food: ${preferredFood}</p>
                <p class="card-text">Color: ${color}</p>
                <p class="card-text">Age: ${age} years</p>
                <p class="card-text">Gender: ${gender}</p>
                <p class="card-text">Price: ${price} $</p>
                <p class="card-text">Comment: ${comment}</p>
              </div>
            </div>
          </div>
          `
          break;
        case "Fish":
          imageSrc = "images/fish3.jpg";
          isFreshWater = $(this).find("isFreshWater").text();
          isPredator = $(this).find("isPredator").text();
          cardHtml =
          `
          <div class="col">
            <div class="card card-margin">
              <img
              class="card-img-top"
              src="${imageSrc}"
              alt="Card image"
              />
              <div class="card-body">
                <p class="card-text">Name: ${name}</p>
                <p class="card-text">Species: ${species}</p>
                <p class="card-text">Freshwater: ${isFreshWater == "true" ? "Yes" : "No"}</p>
                <p class="card-text">Predator: ${isPredator == "true" ? "Yes" : "No"}</p>
                <p class="card-text">Color: ${color}</p>
                <p class="card-text">Age: ${age} years</p>
                <p class="card-text">Gender: ${gender}</p>
                <p class="card-text">Price: ${price} $</p>
                <p class="card-text">Comment: ${comment}</p>
              </div>
            </div>
          </div>
          `
          break;
        case "Various":
          imageSrc = "images/various.jpg";
          cardHtml =
          `
          <div class="col">
            <div class="card card-margin">
              <img
              class="card-img-top"
              src="${imageSrc}"
              alt="Card image"
              />
              <div class="card-body">
                <p class="card-text">Name: ${name}</p>
                <p class="card-text">Species: ${species}</p>
                <p class="card-text">Color: ${color}</p>
                <p class="card-text">Age: ${age} years</p>
                <p class="card-text">Gender: ${gender}</p>
                <p class="card-text">Price: ${price} $</p>
                <p class="card-text">Comment: ${comment}</p>
              </div>
            </div>
          </div>
          `
          break;  
        default:
          imageSrc = "images/bence.png";
          cardHtml =
          `
          <div class="col">
            <div class="card card-margin">
              <img
              class="card-img-top"
              src="${imageSrc}"
              alt="Card image"
              />
              <div class="card-body">
                <p class="card-text">Name: ${name}</p>
                <p class="card-text">Species: ${species}</p>
                <p class="card-text">Color: ${color}</p>
                <p class="card-text">Age: ${age} years</p>
                <p class="card-text">Gender: ${gender}</p>
                <p class="card-text">Price: ${price} $</p>
                <p class="card-text">Comment: ${comment}</p>
              </div>
            </div>
          </div>
          `
          break;
      }
      
      $("#cards").append(cardHtml);
    });
});

$.get("../../kennelReservations.xml", function (xml, status) {
  console.log("Reading kennel reservations");

  var vacancyAvaliableAmount = 10;
  $(xml)
    .find("kennelReservations")
    .each(function () {

      let startDateDay = $(this).find("startDate day").text();
      let startDateMonth = $(this).find("startDate month").text();
      let startDateYear = $(this).find("startDate year").text();

      let endDateDay = $(this).find("endDate day").text();
      let endDateMonth = $(this).find("endDate month").text();
      let endDateYear = $(this).find("endDate year").text();

      let today = new Date();
      let startDate = new Date(startDateYear, startDateMonth - 1, startDateDay);
      let endDate = new Date(endDateYear, endDateMonth - 1, endDateDay);

      if (today >= startDate && today <= endDate) {
        console.log("Vacancy decreased");
        vacancyAvaliableAmount--;
      }

    });

  var textToAppend = `<h3 class="vacancy">
                        Total number of avaliable vacancies:
                        <p>
                        ${vacancyAvaliableAmount < 0 ? 0 : vacancyAvaliableAmount}
                        </p>
                      </h3>`;
  $("#vacancy").append(textToAppend);
});