/*jshint eqeqeq:false */
(function (window) {
	'use strict';

	var URL = 'http://localhost:9999/todo/';

	/**
	 * Creates a new client side storage object and will create an empty
	 * collection if no collection already exists.
	 *
	 * @param {string} name The name of our DB we want to use
	 * @param {function} callback Our fake DB uses callbacks because in
	 * real life you probably would be making AJAX calls
	 */
	function Store(name, callback) {
		callback = callback || function () {};

		window.fetch(URL + 'all')
			.then(response => {
				if (response.status !== 200) {
					throw new Error("Error while fetching getAllItems. Response status: " + response.status);
				}
				return response.json();
			})
			.then(data => callback.call(this, data));

	}

	/**
	 * Finds items based on a query given as a JS object
	 *
	 * @param {object} query The query to match against (i.e. {foo: 'bar'})
	 * @param {function} callback	 The callback to fire when the query has
	 * completed running
	 *
	 * @example
	 * db.find({foo: 'bar', hello: 'world'}, function (data) {
	 *	 // data will return any items that have foo: bar and
	 *	 // hello: world in their properties
	 * });
	 */
	Store.prototype.find = function (query, callback) {
		if (!callback) {
			return;
		}

		window.fetch(URL + 'all')
			.then(response => {
				if (response.status !== 200) {
					throw new Error("Error while fetching getAllItems. Response status: " + response.status);
				}
				return response.json();
			})
			.then(data => callback.call(this, data.filter(todo => {
				for (var q in query) {
					if (query[q] !== todo[q]) {
						return false;
					}
				}
				return true;
			})));

	};

	/**
	 * Will retrieve all data from the collection
	 *
	 * @param {function} callback The callback to fire upon retrieving data
	 */
	Store.prototype.findAll = function (callback) {
		callback = callback || function () {};

		window.fetch(URL + 'all')
			.then(response => {
				if (response.status !== 200) {
					throw new Error("Error while fetching getAllItems. Response status: " + response.status);
				}
				return response.json();
			})
			.then(data => callback.call(this, data));

	};

	/**
	 * Will save the given data to the DB. If no item exists it will create a new
	 * item, otherwise it'll simply update an existing item's properties
	 *
	 * @param {object} updateData The data to save back into the DB
	 * @param {function} callback The callback to fire after saving
	 * @param {number} id An optional param to enter an ID of an item to update
	 */
	Store.prototype.save = function (updateData, callback, id) {
		// var todos = JSON.parse(localStorage.getItem(this._dbName));

		callback = callback || function() {};

		// If an ID was actually given, find the item and update each property
		if (id) {

			window.fetch(URL + id)
				.then(response => {
					if (response.status !== 200) {
						throw new Error("Error while fetching updateItem. Response status: " + response.status);
					}
					return response.json();
				})
				.then(data => {
					for (let key in updateData) {
						data[key] = updateData[key];
					}
					data.id = id;

					window.fetch(URL + id, {
						method: 'PUT',
						headers: {
							'Accept': 'application/json',
							'Content-Type': 'application/json'
						},
						body: JSON.stringify(data)
					}).then(() => callback.call(this, [data]));
				});


		} else {
			// Generate an ID
			updateData.id = new Date().getTime();

			window.fetch(URL + 'add', {
				method: 'POST',
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(updateData)
			}).then(() => callback.call(this, [updateData]));

		}
	};

	/**
	 * Will remove an item from the Store based on its ID
	 *
	 * @param {number} id The ID of the item you want to remove
	 * @param {function} callback The callback to fire after saving
	 */
	Store.prototype.remove = function (id, callback) {
		window.fetch(URL + id, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		});
		window.fetch(URL + 'all')
			.then(response => {
				if (response.status !== 200) {
					throw new Error("Error while fetching deleteItem. Response status: " + response.status);
				}
				return response.json();
			})
			.then(data => callback.call(this, data));

	};

	/**
	 * Will drop all storage and start fresh
	 *
	 * @param {function} callback The callback to fire after dropping the data
	 */
	Store.prototype.drop = function (callback) {
		window.fetch(URL + 'drop', {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		});
		callback.call(this, []);

	};

	// Export to window
	window.app = window.app || {};
	window.app.Store = Store;
})(window);
