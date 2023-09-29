import type { FC } from "react";
import {Navbar, Dropdown, Avatar } from "flowbite-react";

const ExampleNavbar: FC = function () {
  return (
    <Navbar fluid rounded>
      <div className="w-full p-3 lg:px-5 lg:pl-3">
        <div className="flex items-center justify-between">
          <div className="flex items-center">
            <Navbar.Brand href="/">
              <img alt="" src="/images/logo.svg" className="mr-3 h-6 sm:h-8" />
              <span className="self-center whitespace-nowrap text-2xl font-semibold dark:text-white">
              </span>
            </Navbar.Brand>
          </div>

          <div className="flex md:order-2">
            <Dropdown
              arrowIcon={false}
              inline
              label={<Avatar alt="User settings" img="/images/user/jardielma.png" rounded/>}
            >
              <Dropdown.Header>
                <span className="block text-sm">
                  Jardielma Lima
                </span>
                <span className="block truncate text-sm font-medium">
                  jardielma.lima@cielodev.com
                </span>
              </Dropdown.Header>
            </Dropdown>
            <Navbar.Toggle />
          </div>

        </div>
      </div>

    </Navbar>
  );
};

export default ExampleNavbar;
