
function searchPackages() {
    var originCity = document.getElementById('originCity').value;
    var destinationCity = document.getElementById('destinationCity').value;

    if (originCity && destinationCity) {
        // Show loader while waiting for response
        document.getElementById('loader').style.display = 'block';

        fetch(`/expedia/offers?originCity=${originCity}&destinationCity=${destinationCity}`)
            .then(response => response.json())
            .then(data => {
                // Hide loader once response is received
                document.getElementById('loader').style.display = 'none';
                displayPackages(data);
            })
            .catch(error => {
                // Hide loader in case of error
                document.getElementById('loader').style.display = 'none';
                console.error('Error fetching data:', error);
                alert('There was an error fetching the packages.');
            });
    } else {
        alert('Please enter both origin and destination cities!');
    }
}

function displayPackages(data) {
    const container = document.getElementById('packageList');
    container.innerHTML = ''; // Clear previous results

    if (!data || !data.offers || !data.offers.Package || data.offers.Package.length === 0) {
        container.innerHTML = "<p class='text-danger'>No packages found for the selected cities.</p>";
        return;
    }

    data.offers.Package.forEach(offer => {
        const offerCard = document.createElement('div');
        offerCard.classList.add('card', 'mb-3', 'shadow-sm');

        offerCard.innerHTML = `
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="${offer.hotelInfo.hotelImageUrl}" class="img-fluid rounded-start" alt="Hotel Image">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">${offer.hotelInfo.hotelName}</h5>
                        <p class="card-text"><strong>Destination:</strong> ${offer.destination.displayDestination}</p>
                        <p class="card-text"><strong>Travel Dates:</strong> ${offer.offerDateRange.formattedTravelStartDate} - ${offer.offerDateRange.formattedTravelEndDate}</p>
                        <p class="card-text"><strong>Flight Carrier:</strong> ${offer.flightInfo.flightDealCarrier}</p>
                        <p class="card-text"><strong>Hotel Rating:</strong> ${offer.hotelInfo.hotelStarRating} stars</p>
                        <p class="card-text"><strong>Total Price:</strong> ${offer.packagePricingInfo.formattedTotalPriceValue}</p>
                        <a href="${offer.packageUrls.decodedPackageSearchUrl}" target="_blank" class="btn btn-primary">View Package</a>
                    </div>
                </div>
            </div>
        `;

        container.appendChild(offerCard);
    });
}
